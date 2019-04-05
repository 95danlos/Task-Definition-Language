#!/usr/bin/python

import socket
import sys

HOST, PORT = "localhost", 9001
data = "hei".join(sys.argv[1:])

# SOCK_DGRAM is the socket type to use for UDP sockets
sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

# As you can see, there is no connect() call; UDP has no connections.
# Instead, data is directly sent to the recipient via sendto().
sock.sendto(data + "\n", (HOST, PORT))
received = sock.recv(1024)

print "Sent:     {}".format(data)
print "Received: {}".format(received)


import rospy
import tf
import math
from std_msgs.msg import String
from tf2_msgs.msg import TFMessage
from math import sin, cos, pi
from nav_msgs.msg import Odometry
from sensor_msgs.msg import LaserScan
from geometry_msgs.msg import Point, Pose, Quaternion, Twist, Vector3, TransformStamped
from time import sleep as _sleep
from geometry_msgs.msg import Pose
from geometry_msgs.msg import Twist
from gazebo_msgs.srv import GetModelState
from gazebo_msgs.srv import SetModelState
from gazebo_msgs.msg import ModelState
from time import sleep as _sleep
from geometry_msgs.msg import *
from geometry_msgs.msg import *
from gazebo_msgs.srv import *
from gazebo_msgs.msg import *
rospy.init_node('youbot', anonymous=True)
set_state = rospy.ServiceProxy("/gazebo/set_model_state",SetModelState)
twist = Twist()
state = ModelState()
state.model_name = "youbot"
state.reference_frame = "youbot"
def goTo(lat,lng):
		import actionlib
		from move_base_msgs.msg import MoveBaseAction, MoveBaseGoal
		client = actionlib.SimpleActionClient('youbot/move_base', MoveBaseAction)  
		client.wait_for_server()
		goal = MoveBaseGoal()
		goal.target_pose.header.frame_id = "map"
		goal.target_pose.pose.position.x = lng
		goal.target_pose.pose.position.y = lat  
		goal.target_pose.pose.orientation.w = 1
		client.send_goal(goal)
		r = rospy.Rate(0.5)
		status = ""
		while (not rospy.is_shutdown() and status != "Goal reached."):
		  status = client.get_goal_status_text()
		  r.sleep()
def moveToGoal():
		get_state = rospy.ServiceProxy("/gazebo/get_model_state", GetModelState)
		set_state = rospy.ServiceProxy("/gazebo/set_model_state",SetModelState)
		pose = Pose()
		state = ModelState()
		state.model_name = "youbot"
		state.reference_frame = "map"
		rospy.wait_for_service("/gazebo/get_model_state")
		get_state = rospy.ServiceProxy("/gazebo/get_model_state", GetModelState)
		response = get_state("robocup_3d_goal", "")
		response_2 = get_state("soccer_ball", "")
		quaternion = (
			response.pose.orientation.x,
			response.pose.orientation.y,
			response.pose.orientation.z,
			response.pose.orientation.w)
		euler = tf.transformations.euler_from_quaternion(quaternion)
		roll = euler[0]
		pitch = euler[1]
		yaw = euler[2]
		yaw = yaw - 3.4
		quaternion = tf.transformations.quaternion_from_euler(roll, pitch, yaw)
		pose.position.x = -1.8
		pose.position.y = 12
		pose.orientation.x = quaternion[0]
		pose.orientation.y = quaternion[1]
		pose.orientation.z = quaternion[2]
		pose.orientation.w = quaternion[3]
		state.pose = pose
		ret = set_state(state)
def moveToBall():
		get_state = rospy.ServiceProxy("/gazebo/get_model_state", GetModelState)
		set_state = rospy.ServiceProxy("/gazebo/set_model_state",SetModelState)
		pose = Pose()
		state = ModelState()
		state.model_name = "youbot"
		state.reference_frame = "map"
		rospy.wait_for_service("/gazebo/get_model_state")
		get_state = rospy.ServiceProxy("/gazebo/get_model_state", GetModelState)
		response = get_state("robocup_3d_goal", "")
		response_2 = get_state("soccer_ball", "")
		quaternion = (
			response.pose.orientation.x,
			response.pose.orientation.y,
			response.pose.orientation.z,
			response.pose.orientation.w)
		euler = tf.transformations.euler_from_quaternion(quaternion)
		roll = euler[0]
		pitch = euler[1]
		yaw = euler[2]
		yaw = yaw - 3.6
		quaternion = tf.transformations.quaternion_from_euler(roll, pitch, yaw)
		pose.position.x = -2.8
		pose.position.y = 8.2
		pose.orientation.x = quaternion[0]
		pose.orientation.y = quaternion[1]
		pose.orientation.z = quaternion[2]
		pose.orientation.w = quaternion[3]
		state.pose = pose
		ret = set_state(state)
def kickBall():
		state = ModelState()
		state.model_name = "youbot"
		state.reference_frame = "youbot"
		set_state = rospy.ServiceProxy("/gazebo/set_model_state",SetModelState)
		pose = Pose()
		twist = Twist()
		_sleep(2)
		twist.linear.x = -3
		twist.linear.y = 0
		twist.angular.z = 0
		state.twist = twist
		ret = set_state(state)
		_sleep(1)
		twist.linear.x = 0
		twist.linear.y = 0
		twist.angular.z = 0
		state.twist = twist
		ret = set_state(state)
def faceBall():
		_sleep(1)
def aim():
		_sleep(1)
def moveForward():
		twist.linear.x = 2
		twist.angular.z = 0
		state.twist = twist
		ret = set_state(state)
		_sleep(2)
		twist.linear.x = 0
		twist.angular.z = 0
		state.twist = twist
		ret = set_state(state)
def moveBackwards():
		twist.linear.x = -2
		twist.angular.z = 0
		state.twist = twist
		ret = set_state(state)
		_sleep(2)
		twist.linear.x = 0
		twist.angular.z = 0
		state.twist = twist
		ret = set_state(state)
def turnLeft():
		twist.linear.x = 0
		twist.angular.z = 4
		state.twist = twist
		ret = set_state(state)
		_sleep(2)
		twist.linear.x = 0
		twist.angular.z = 0
		state.twist = twist
		ret = set_state(state)
def turnRight():
		twist.linear.x = 0
		twist.angular.z = -4
		state.twist = twist
		ret = set_state(state)
		_sleep(2)
		twist.linear.x = 0
		twist.angular.z = 0
		state.twist = twist
		ret = set_state(state)
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
    robot_sensor_data_topic.publish(json.dumps(my_sensor_data))
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
    print(robot_status_table.get("robot_id"), ", Distance: ", d)
    return -d
def check_action_dependency(action):
    print("checking")
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
my_sensor_data = {
		"robot_id": "youbot",
        "topics": [
        {
          "topic_name" : "lat",
          "topic_value" : "0"
        },
        {
          "topic_name" : "lng",
          "topic_value" : "0"
        },
        ]
    }
def lat_callback(sensor_value_json):
	sensor_value = json.loads(sensor_value_json.data)
	for topic in my_sensor_data["topics"]:
		if topic.get("topic_name") == "lat":
			topic["topic_value"] = sensor_value
rospy.Subscriber("youbot/lat", String, lat_callback)
def lng_callback(sensor_value_json):
	sensor_value = json.loads(sensor_value_json.data)
	for topic in my_sensor_data["topics"]:
		if topic.get("topic_name") == "lng":
			topic["topic_value"] = sensor_value
rospy.Subscriber("youbot/lng", String, lng_callback)
my_actions_table = {
        "actions": [
        {
          "action_name" : "goTo",
          "action_status" : "not_doing"
        },
        {
          "action_name" : "moveToGoal",
          "action_status" : "not_doing"
        },
        {
          "action_name" : "moveToBall",
          "action_status" : "not_doing"
        },
        {
          "action_name" : "kickBall",
          "action_status" : "not_doing"
        },
        {
          "action_name" : "faceBall",
          "action_status" : "not_doing"
        },
        {
          "action_name" : "aim",
          "action_status" : "not_doing"
        },
        {
          "action_name" : "moveForward",
          "action_status" : "not_doing"
        },
        {
          "action_name" : "moveBackwards",
          "action_status" : "not_doing"
        },
        {
          "action_name" : "turnLeft",
          "action_status" : "not_doing"
        },
        {
          "action_name" : "turnRight",
          "action_status" : "not_doing"
        },
        ]
    }
robot_status_table = {
        "robot_id": "youbot",
        "ip_address": "0",
        "recovering": "0",
        "recovered_from_task_with_id": "0"
    }
robot_sensor_data_topic = rospy.Publisher('sensor_data', String, queue_size=10)
"""
    @start Task Allocation Module Part 3
"""
task_status = {}
if __name__ == '__main__':
    runtime_engine_slave()
"""
    @end Task Allocation Module Part 3
"""
