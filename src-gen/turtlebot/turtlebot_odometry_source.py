#!/usr/bin/python
import rospy
import tf
import time
from std_msgs.msg import String
from tf2_msgs.msg import TFMessage
from math import sin, cos, pi
from nav_msgs.msg import Odometry
from sensor_msgs.msg import LaserScan
from geometry_msgs.msg import Point, Pose, Quaternion, Twist, Vector3, TransformStamped
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
lat_pub = rospy.Publisher("lat", String, queue_size=50)
lng_pub = rospy.Publisher("lng", String, queue_size=50)
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
	odom_broadcaster.sendTransform(
	(response.pose.position.x, response.pose.position.y, 0.),
	quaternion,
	current_time,
	"base_link",
	"odom"
	)
	odom = Odometry()
	odom.header.stamp = current_time
	odom.header.frame_id = "odom"
	odom.pose.pose = response.pose
	odom.child_frame_id = "base_link"
	odom.twist.twist = response.twist
	odom_pub.publish(odom)
	lat_pub.publish(str(response.pose.position.y))
	lng_pub.publish(str(response.pose.position.x))  
	r.sleep()
