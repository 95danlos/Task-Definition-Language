#!/usr/bin/python

import rospy
import tf
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

rospy.init_node('odometry_source', anonymous=True)


rospy.wait_for_service("/gazebo/get_model_state")
rospy.wait_for_service("/gazebo/set_model_state")
get_state = rospy.ServiceProxy("/gazebo/get_model_state", GetModelState)
set_state = rospy.ServiceProxy("/gazebo/set_model_state", SetModelState)

odom_pub = rospy.Publisher("odom", Odometry, queue_size=50)
odom_broadcaster = tf.TransformBroadcaster()


r = rospy.Rate(20)
while (not rospy.is_shutdown()):
	current_time = rospy.Time.now()

	response = get_state("turtlebot", "")


	quaternion = (
	    response.pose.orientation.x,
	    response.pose.orientation.y,
	    response.pose.orientation.z,
	    response.pose.orientation.w)
	euler = tf.transformations.euler_from_quaternion(quaternion)
	roll = euler[0]
	pitch = euler[1]
	yaw = euler[2]

	# since all odometry is 6DOF we'll need a quaternion created from yaw
	#odom_quat = tf.transformations.quaternion_from_euler(0, 0, th)
	
	
	# first, we'll publish the transform over tf
	odom_broadcaster.sendTransform(
	(response.pose.position.x, response.pose.position.y, 0.),
	quaternion,
	current_time,
	"base_link",
	"odom"
	)
	


	# next, we'll publish the odometry message over ROS
	odom = Odometry()
	odom.header.stamp = current_time
	odom.header.frame_id = "odom"

	# set the position
	#odom.pose.pose = Pose(Point(x, y, 0.), Quaternion(*odom_quat))
	odom.pose.pose = response.pose

	# set the velocity
	odom.child_frame_id = "base_link"
	odom.twist.twist = response.twist

	# publish the message
	odom_pub.publish(odom)


	r.sleep()





