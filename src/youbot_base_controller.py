#!/usr/bin/python

import rospy
from geometry_msgs.msg import Twist
from gazebo_msgs.srv import SetModelState
from gazebo_msgs.msg import ModelState


def callback(data):

	twist = Twist()

	twist.linear.x = data.linear.x
	twist.linear.y = data.linear.y
	twist.linear.z = data.linear.z

	twist.angular.x = data.angular.x
	twist.angular.y = data.angular.y
	twist.angular.z = data.angular.z


	state = ModelState()

	state.model_name = "youbot"
	state.twist = twist
	state.reference_frame = "youbot" 

	ret = set_state(state)
	


rospy.init_node('base_controller', anonymous=True)
set_state = rospy.ServiceProxy("/gazebo/set_model_state", SetModelState)
rospy.Subscriber("cmd_vel", Twist, callback)

rospy.spin()



