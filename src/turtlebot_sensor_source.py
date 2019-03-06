#!/usr/bin/python

import rospy
from sensor_msgs.msg import LaserScan

rospy.init_node('sensor_source', anonymous=True)

scan_pub = rospy.Publisher('scan', LaserScan, queue_size=50)


def callback(data):
	scan_pub.publish(data)
	

rospy.Subscriber("turtlebot/scan", LaserScan, callback)

rospy.spin()
