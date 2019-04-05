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
            
        # Check if action should wait for another robots action to finish before starting
        if(action.get("after_action")!= None):
          while (not check_action_dependency(action)):
            time.sleep(0.1)

        # Start action
        if(action.get("positioning_action")=="True"):
          t = threading.Thread(target=globals()[action.get("action_name")](task_status.get("lat"), task_status.get("lng")))
        else:
          t = threading.Thread(target=globals()[action.get("action_name")]())
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
    
    my_lat = ""
    my_lng = ""
    for topic in my_sensor_data["topics"]:
        if topic.get("topic_name") == "lat":
            my_lat = topic.get("topic_value")
        if topic.get("topic_name") == "lng":
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


def check_action_dependency(action):
    if(action.get("after_action")!= None):
      for composite_task in mission_table_g["composite_tasks"]:
        if composite_task.get("composite_task_id") == task_status.get("composite_task_id"):
          for task in composite_task["tasks"]:
            for action_2 in task["actions"]:
              if action_2.get("action_id") != None and action_2.get("action_id") == action.get("after_action"):
                if action_2.get("action_status") == "completed":
                  return True
    return False

"""

    @end Task Allocation Module Part 2

"""
  








"""

    @start Task Allocation Module Part 3

"""

task_status = {}
    


if __name__ == '__main__':
    runtime_engine_slave()



"""

    @end Task Allocation Module Part 3

"""
