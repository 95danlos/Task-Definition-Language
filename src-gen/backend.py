
"""
    @start Backend Part 1
"""
import sys, ast, math
import time
import json
import subprocess
import threading
ROS_MASTER_URI = None
ROS_MASTER_ID = None
leader_client = None
web_client = None
import logging
from websocket_server import WebsocketServer
def main():
    print('\033[94m' + "Server Started" + '\033[0m')
    HTTP_PORT = 8000
    WEBSOCKET_PORT = 9001
    server = WebsocketServer(9001, host='0.0.0.0')
    server.set_fn_message_received(message_received)
    server.run_forever()
    #server = CombiServer(HTTP_PORT,WEBSOCKET_PORT)
    #server.set_fn_message_received(message_received)
    #with server:
    #    while True:
    #       time.sleep(1)
# Called when client sends new tasks from web interface or when robots ask for team leaders ip address
def message_received(client, server, message):
    message = ast.literal_eval(message)
    global ROS_MASTER_URI
    global ROS_MASTER_ID
    # If flag == 0 robot is requesting team leaders ip address
    if (message[0] == "0"):
        # If there is no leader assign lead to this robot
        if ROS_MASTER_ID == None:
            ROS_MASTER_URI = message[2]
            ROS_MASTER_ID = message[1]
            print('\033[94m' + "New Leader:  " + message[1] + '\033[0m')
        else:
            print('\033[94m' + "New Robot:  " + message[1] + '\033[0m')
        server.send_message(client, json.dumps([ROS_MASTER_ID, ROS_MASTER_URI]))
    # If flag == 2 mission updates from leader
    if (message[0] == "2"):
        if web_client != None:
            server.send_message(web_client ,json.dumps(message))
    # If flag == 3 Task Definitions from web interface on startup
    if (message[0] == "3"):
        print('\033[94m' + "Web Client Connected" + '\033[0m')
        global web_client
        web_client = client
    # If flag == 1 new tasks recieved from client
    if (message[0] == "1"):
        print('\033[94m' + "New Tasks Sent" + '\033[0m')
        if leader_client != None:
            server.send_message(leader_client, json.dumps(message))
    if (message[0] == "4"):
        print('\033[94m' + "Leader Connected" + '\033[0m')
        global leader_client
        leader_client = client
        server.send_message(client, json.dumps(["11"]))
if __name__ == '__main__':
    try:
        main()
    except:
        pass
"""
mission_table_example = {
    "composite_tasks": [
    {
        "composite_tasks_id": "1"
        "composite_tasks_name": "2_robots_move_forward_and_back"
        "tasks": [
          {
            "task_id": "1.1",
            "robot_id": "0",
            "auction_status": "open",
            "task_status": "not_started",
            "actions": [
              {
                "action_name": "moveForward",
                "action_status": "not_started",
                "max_time": "10",
              },
              {
                "action_name": "moveForward",
                "action_status": "not_started",
                "max_time": "10",
              }
            ],
            "bids": [],
            "ignore_robots": []
          },
          {
            "task_id": "1.2",
            "robot_id": "0",
            "auction_status": "open",
            "task_status": "not_started",
            "actions": [
              {
                "action_name": "turnLeft",
                "action_status": "not_started",
                "max_time": "10",
              },
              {
                "action_name": "turnLeft",
                "action_status": "not_started",
                "max_time": "10",
              }
            ],
            "bids": [],
            "ignore_robots": []
          }
        ]
    ]
    }
}
"""
"""
    @end Backend Part 1
"""

