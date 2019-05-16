#!/usr/bin/python
import rospy
from std_msgs.msg import String
rospy.init_node('odometry_source', anonymous=True)
lat_pub = rospy.Publisher("lat", String, queue_size=50)
lng_pub = rospy.Publisher("lng", String, queue_size=50)
r = rospy.Rate(20)
while (not rospy.is_shutdown()):
	lat_pub.publish("2")
	lng_pub.publish("0")                    
	r.sleep()
