SERVER_IP_ADDRESS = "localhost"
import time
import subprocess
robot_status_table = {
        "robot_id": "pc",
        "ip_address": "0",
    }
			    
			    
def get_ros_master_ip_address_from_server():
    server_response = None
    ws = None
    while server_response == None:
        try:
            import json
            import sys, ast, math
            from websocket import create_connection
            ws = create_connection("ws://" + SERVER_IP_ADDRESS + ":9001/")
            ws.send(json.dumps(["0", robot_status_table.get("robot_id"), robot_status_table.get("robot_ip_address")]))
            server_response = ast.literal_eval(ws.recv())
        except:
          print('\033[94m' + robot_status_table.get("robot_id") + ": Trying to Connect to Server" + '\033[0m')
          time.sleep(2)
        finally:
          if ws != None:
              ws.close()
    return server_response
			    
			    
if __name__ == '__main__':

    import socket    
    s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    s.connect(("8.8.8.8", 80))
    robot_status_table["robot_ip_address"] = s.getsockname()[0]
    s.close() 

    message = get_ros_master_ip_address_from_server()

    subprocess.Popen("export ROS_MASTER_URI=http://" + message[1] + ":11311; export ROS_IP=" + robot_status_table.get("robot_ip_address") + "; export ROS_HOSTNAME=" + robot_status_table.get("robot_ip_address") + "; roslaunch multi-robot-simulation pc.launch", shell=True).wait()
    	      
