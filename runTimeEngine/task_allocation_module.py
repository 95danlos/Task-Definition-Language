"""
export ROS_IP=10.0.0.19
export ROS_HOSTNAME=10.0.0.19
export ROS_MASTER_URI=http://10.0.0.19:11311

import socket
print(socket.gethostbyname(socket.gethostname()))

IpAddresss = subprocess.check_output(["hostname", "-I"])    // Use HostName insted of ip
print(IpAddresss)

robot id --> unique


"""



"""

    @start Task Allocation Module Part 1

"""



def get_ros_master_ip_address_from_server():
    server_response = None
    ws = None
    while server_response == None:
        try:
            import json
            import sys, ast, math
            from websocket import create_connection
            ws = create_connection("ws://localhost:9001/")
            ws.send(json.dumps(["0", robot_status_table.get("robot_id"), robot_status_table.get("robot_ip_address")]))
            server_response =  ast.literal_eval(ws.recv())
        except:
          print('\033[94m' + "Trying to Connect to Server" + '\033[0m')
          time.sleep(2)
        finally:
          if ws != None:
              ws.close()
    return server_response



from std_msgs.msg import String
import threading
import rospy
import json
import time
import math

    
def runtime_engine_slave():
    #subprocess.Popen("export ROS_IP=10.0.0.19", shell=True).wait()
    #subprocess.Popen("export ROS_HOSTNAME=10.0.0.19", shell=True).wait()
    #subprocess.Popen("export ROS_MASTER_URI=http://10.0.0.10:11311", shell=True).wait()

    # anonymous = True allows multiple nodes with same name
    #rospy.init_node('Slave', anonymous=True)
    bid_table_topic = rospy.Publisher('bid_table', String, queue_size=10)
    task_status_topic = rospy.Publisher('task_status', String, queue_size=10)
    global robot_status_table_topic
    robot_status_table_topic = rospy.Publisher('robot_status_table', String, queue_size=10)
    rospy.Subscriber("mission_table", String, callback, (bid_table_topic, task_status_topic))

    rospy.spin()


def callback(mission_table_string, args):
    mission_table = json.loads(mission_table_string.data)
    bid_table_topic = args[0]
    task_status_topic = args[1]
    
    bid_table = find_new_biddable_tasks(mission_table)
    bid_table_topic.publish(json.dumps(bid_table))
    robot_status_table_topic.publish(json.dumps(robot_status_table))
    
    """

        @end Task Allocation Module Part 1

    """
    
    """

        @start Task Allocation Module Part 2

    """

    start_new_task(mission_table)

    if task_status:
    	task_status_topic.publish(json.dumps(task_status))




"""
    Search for new biddable tasks, 
    @Algorithm for calculating bid value
"""
def find_new_biddable_tasks(mission_table):

    bid_table = {
        "tasks": []
    }
    
    for composite_task in mission_table["composite_tasks"]:
        for task in composite_task["tasks"]:
    
            # If task is biddable
            if task.get("auction_status") == "open":
                
                # If task is doable by this robot send bid
                if check_if_task_is_doable(task.get("task_id"), mission_table):
                    bid_table["tasks"].append({
                        "task_id" : task.get("task_id"),
                        "robot_id" : robot_status_table.get("robot_id"),
                        "bid_value" : calculate_bid(composite_task)
                        })

    return bid_table




    """
        Start new task if this robot has won any
    """
def start_new_task(mission_table):
    
    global mission_table_g
    mission_table_g = mission_table
    
    # For each task
    for composite_task in mission_table["composite_tasks"]:
        for task in composite_task["tasks"]:
    
            # If robot has won the task and not started yet
            if task.get("robot_id") == robot_status_table.get("robot_id") and task.get("task_status") != "completed" and not is_task_started(task.get("task_id")):
                global task_status
                task_status = {
                    "task_id" : task.get("task_id"),
                    "robot_id" : robot_status_table.get("robot_id"),
                    "task_status" : "started",
                    "actions": task["actions"],
                    "positioning_action" : task.get("positioning_action"),
                    "lng": composite_task.get("lng"),
                    "lat": composite_task.get("lat"),
                    "composite_task_id": composite_task.get("composite_task_id")
                }
    
                # Start task
                t = threading.Thread(target=start_executing_task)
                t.start()



def is_task_started(task_id):
    return task_status.get("task_id") == task_id


def start_executing_task():
    failed = False
    for action in task_status["actions"]:
        action["action_status"] = "started"
        action["start_time"] = time.time()
        max_time = action.get("max_time")

        # If action has no max time limit
        if max_time == None:
            max_time = 999999
            
        # Check if action should wait for another robots action to finish before starting, sync or atfer
        while (not action_is_ready_to_start(action)):
          time.sleep(0.1)

        # Start action
        if(action.get("positioning_action")=="True"):
          t = threading.Thread(target=globals()[action.get("action_name")](task_status.get("lat"), task_status.get("lng")))
        else:
          t = threading.Thread(target=globals()[action.get("action_name")](*action.get("arguments")))
        t.start()

        i = 0
        while (i < max_time):
            if not t.isAlive():
                break
            else:
                time.sleep(1)
                i = i + 1

        # if thread not finished in time, task failed
        if (i >= max_time):
            action["action_status"] = "Failed"
            failed = True
            robot_status_table["recovering"] = "1"

            # Wait for method to terminate
            t_2 = threading.Thread(target=waif_for_method(t))
            t_2.start()

            print("Failed Task")
        else:
            action["action_status"] = "completed"

    if failed:
        task_status["task_status"] = "Failed"
    else:
        task_status["task_status"] = "completed"


def waif_for_method(t):
    while True:
        if not t.isAlive():
            robot_status_table["recovered_from_task_with_id"] = task_status.get("id")  
            robot_status_table["recovering"] = "0" 
            break
        time.sleep(1)


def check_if_task_is_doable(task_id, mission_table):
  task = get_task_by_id(task_id, mission_table)
  task_doable = True
  for action in task["actions"]:
    action_doable = False
    for my_action in my_actions_table["actions"]:
      if my_action.get("action_name") == action.get("action_name"):
        action_doable = True
    if action_doable == False:
        task_doable = False
  return task_doable
  
  
def get_task_by_id(task_id, mission_table):
    for composite_task in mission_table["composite_tasks"]:
        for task in composite_task["tasks"]:
            if task.get("task_id") == task_id:
                return task
  
  
def calculate_bid(composite_task):
    from math import sin, cos, sqrt, atan2, radians
    
    my_lat = 0.0
    my_lng = 0.0
    for topic in my_sensor_data["topics"]:
        if topic.get("topic_name") == "lat" and topic.get("topic_value") != "0":
            my_lat = topic.get("topic_value")
        if topic.get("topic_name") == "lng" and topic.get("topic_value") != "0":
            my_lng = topic.get("topic_value")


    # Approximate radius of earth in km
    R = 6373.0
    
    lat1 = radians(my_lat)
    lon1 = radians(my_lng)
    lat2 = radians(composite_task.get("lat"))
    lon2 = radians(composite_task.get("lng"))

    dlon = lon2 - lon1
    dlat = lat2 - lat1

    a = sin(dlat / 2)**2 + cos(lat1) * cos(lat2) * sin(dlon / 2)**2
    c = 2 * atan2(sqrt(a), sqrt(1 - a))
    
    
    # Distance in meters --> If not using simulator 
    d = R * c * 1000

    return -d


def action_is_ready_to_start(action):
    ready = True
    if action.get("after_action")!= None:
      for composite_task in mission_table_g["composite_tasks"]:
        if composite_task.get("composite_task_id") == task_status.get("composite_task_id"):
          for task in composite_task["tasks"]:
            for action_2 in task["actions"]:
              if action_2.get("action_id") != None and action_2.get("action_id") == action.get("after_action"):
                if action_2.get("action_status") != "completed":
                  ready = False
    
    if action.get("sync_number")!= None:
      for composite_task in mission_table_g["composite_tasks"]:
        if composite_task.get("composite_task_id") == task_status.get("composite_task_id"):
          for task in composite_task["tasks"]:
            action_2_prev = None
            for action_2 in task["actions"]:
              if action_2.get("sync_number") != None and action_2.get("sync_number") == action.get("sync_number"):
                if action_2_prev != None and action_2_prev.get("action_status") != "completed":
                  ready = False
              
              action_2_prev = action_2

    return ready

"""

    @end Task Allocation Module Part 2

"""


"""

    @start Task Allocation Module Part 3

"""


from std_msgs.msg import String
import subprocess
import threading
import rospy
import time
import json
def runtime_engine_master():
    def start(ws):
        #subprocess.Popen("export ROS_IP=10.0.0.10", shell=True).wait()
        #subprocess.Popen("export ROS_HOSTNAME=10.0.0.10", shell=True).wait()
        #subprocess.Popen("export ROS_MASTER_URI=http://10.0.0.10:11311", shell=True).wait()
        #ROS_Master_Node_Process = subprocess.Popen(["roscore"])
        #rospy.init_node('Master', anonymous=True)
        # Tables sent from master
        mission_table_topic = rospy.Publisher('mission_table', String, queue_size=10)
        # Tables sent to master
        rospy.Subscriber("bid_table", String, callback)
        rospy.Subscriber("task_status", String, callback_2)
        rospy.Subscriber("robot_status_table", String, callback_3)
        rospy.Subscriber("sensor_data", String, callback_4)
        # Start auction
        # Start publishing tasks
        rate = rospy.Rate(2)
        while not rospy.is_shutdown():
            mission_table_topic.publish(json.dumps(mission_table))
            rate.sleep()
            distribute_tasks()
            ws.send(json.dumps(["2", robot_sensor_data_master]))
    def callback(bid_table_json):
        bid_table = json.loads(bid_table_json.data)
        merge_bids(bid_table)
    def callback_2(task_status_json):
        task_status = json.loads(task_status_json.data)
        update_task_status(task_status)
    def callback_3(robot_status_table_json):
        robot_status_table = json.loads(robot_status_table_json.data)
        update_robot_status(robot_status_table)
    def callback_4(sensor_data_json):
        sensor_data = json.loads(sensor_data_json.data)
        update_sensor_data(sensor_data)
    def update_sensor_data(sensor_data):
        found = False
        for robot in robot_sensor_data_master["robots"]:
          if robot.get("robot_id") == sensor_data.get("robot_id"):
            robot["topics"] = sensor_data["topics"]
            found = True
        # If robot is not in sensor data table
        if not found:
          robot_sensor_data_master["robots"].append(sensor_data)
    def update_task_status(task_status):
        for composite_task in mission_table["composite_tasks"]:
            for task in composite_task["tasks"]:
              if task.get("task_id") == task_status.get("task_id"):
                task["actions"] = task_status["actions"]
                task["task_status"] = task_status["task_status"]
                # check if task has failed
                if (task_status["task_status"] == "Failed"):
                  for robot in robot_status_table_master["robots"]:
                    if robot.get("robot_id") == task_status.get("robot_id"):
                      robot["recovering"] == "1"
                  print("Master: Task Failed")
    def update_robot_status(robot_status_table):
      found = False
      for robot in robot_status_table_master["robots"]:
        if robot.get("robot_id") == robot_status_table.get("robot_id"):
          robot = robot_status_table
          found = True
          robot["recovering"] = "0"
          robot["recovered_from_task_with_id"] = "0"
      if not found:
        robot_status_table_master["robots"].append(robot_status_table)
    """
        Merge new bids into mission table
    """
    def merge_bids(bid_table_from_robot):
      # Find each task the robot has bidded on
      for task_to_bid_on in bid_table_from_robot["tasks"]:
          # Find task in mission table                                    use get_task_by_id function   -----------------------------------------------
          for composite_task in mission_table["composite_tasks"]:
            for task in composite_task["tasks"]:
              if task_to_bid_on.get("task_id") == task.get("task_id"):
                # Check if bid from this robot allready exists
                bid_allredy_exists = False
                for bid in task["bids"]:
                  # If bid allready exists override old bid
                  if bid.get("robot_id") == task_to_bid_on.get("robot_id"):
                    bid["bid_value"] = task_to_bid_on.get("bid_value")
                    bid_allredy_exists = True
                # If not add new bid
                if not bid_allredy_exists:
                  task["bids"].append({
                        "robot_id" : task_to_bid_on.get("robot_id"),
                        "bid_value" : task_to_bid_on.get("bid_value")
                        })
    """
        Distribute tasks
    """
    def distribute_tasks():
        for composite_task in mission_table["composite_tasks"]:
            for task in composite_task["tasks"]:
                # Check that task is biddable
                if task.get("auction_status") == "open":
                  highest_bidder = None
                  highest_bidder_value = None
                  for bid in task["bids"]:
                    if bid.get("bid_value") > highest_bidder_value and robot_is_available(bid.get("robot_id")):
                      highest_bidder = bid.get("robot_id")
                      highest_bidder_value = bid.get("bid_value")
                  # check that there where atleast one bid
                  if highest_bidder is not None:
                    task["robot_id"] = highest_bidder
                    task["auction_status"] = "sold"
    def robot_is_available(robot_id):
        for composite_task in mission_table["composite_tasks"]:
            for task in composite_task["tasks"]:
                # Check if task is given to the robot and not completed yet
                if task.get("robot_id") == robot_id and task.get("task_status") != "completed":
                  return False
        return True
    def get_task_by_id(task_id):
        for composite_task in mission_table["composite_tasks"]:
            for task in composite_task["tasks"]:
                if task.get("task_id") == task_id:
                    return task
    mission_table = {
            "composite_tasks": []
        }
    robot_status_table_master = {
            "robots": [
            ]
        }
    robot_sensor_data_master = {
            "robots": [
            ]
        }
    
    
    def setup_connection_to_server():
        server_response = None
        ws = None
        while server_response == None:
            try:
                import json
                import sys, ast, math
                from websocket import create_connection
                ws = create_connection("ws://localhost:9001/")
                t = threading.Thread(target=start_listening_on_server, args=(ws,))
                t.daemon = True
                t.start()
                ws.send(json.dumps(["4"]))
                start(ws)
            except:
              print('\033[94m' + "Trying to Connect to Server" + '\033[0m')
              time.sleep(2)
            finally:
              if ws != None:
                  ws.close()


    def start_listening_on_server(ws):
            import json
            import sys, ast, math
            from websocket import create_connection

            while True:
                message =  ast.literal_eval(ws.recv())

                # If flag == 1 new tasks recieved from client
                if (message[0] == "1"):
                    for new_composite_task in message[1]["composite_tasks"]:

                        i = 1
                        new_composite_task_id = len(mission_table["composite_tasks"]) + 1
                        for task in new_composite_task["tasks"]:
                            task["task_id"] = (str(new_composite_task_id) + "." + str(i))
                            i = i + 1

                        new_composite_task["composite_task_id"] = str(new_composite_task_id)
                        mission_table["composite_tasks"].append(new_composite_task)

    setup_connection_to_server()


"""

    @end Task Allocation Module Part 3

"""






"""

    @start Task Allocation Module Part 4

"""

task_status = {}
if __name__ == '__main__':

    import socket    
    s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    s.connect(("8.8.8.8", 80))
    robot_status_table["robot_ip_address"] = s.getsockname()[0]
    s.close() 

    message = get_ros_master_ip_address_from_server()

    # If leader id = this robots id, start runtime engine master
    if message[0] == robot_status_table.get("robot_id"):
      print('\033[94m' + robot_status_table.get("robot_id") + ": Starting Master and Connecting to Server" + '\033[0m')

      # Start task
      t = threading.Thread(target=runtime_engine_master)
      t.daemon = True
      t.start()
      
      robot_status_table["master"] = "True"

    else:
      print('\033[94m' + robot_status_table.get("robot_id") + ": Connecting to Master" + '\033[0m')
      #subprocess.Popen("export ROS_MASTER_URI=http://" + message[0] + ":11311", shell=True).wait()

    runtime_engine_slave()



"""

    @end Task Allocation Module Part 4

"""
