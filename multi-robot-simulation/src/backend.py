
"""
    @start Backend Part 1
"""
import sys, ast, math
import time
import subprocess
import threading
def main():
    print("starting")
    HTTP_PORT = 8000
    WEBSOCKET_PORT = 9001
    server = CombiServer(HTTP_PORT,WEBSOCKET_PORT)
    server.set_fn_message_received(message_received)
    with server:
        runtime_engine_master(server)
        #while True:
            #time.sleep(1)
# Called when a client sends new tasks to the robots
def message_received(client, server, message):
    print("22222222222222")
    print("22222222222222")
    print("22222222222222")
    print("message")
    print(message)
    print(ast.literal_eval(message))
    print("message end")
    server.send_message(client, "1")
    for new_task in ast.literal_eval(message)["tasks"]:
        new_composite_task = {
            "tasks": []
        }
        composite_task_definition = {
            "tasks": []
        }
        for composite_task in task_definitions["composite_tasks"]:
            if composite_task.get("composite_task_name") == new_task.get("name"):
                composite_task_definition["tasks"] = composite_task.get("tasks")
        i = 1
        new_composite_task_id = len(mission_table["composite_tasks"]) + 1
        for task in composite_task_definition["tasks"]:
            new_composite_task["tasks"].append(
            {
                "task_id": (str(new_composite_task_id) + "." + str(i)),
                "task_name": task.get("task_name"),
                "robot_id": "0",
                "auction_status": "open",
                "task_status": "not_started",
                "actions": task.get("actions"),
                "bids": [],
                "ignore_robots": []
            })
            i = i + 1
        new_composite_task["composite_task_id"] = str(new_composite_task_id)
        new_composite_task["composite_task_status"] = "not_started"
        new_composite_task["lat"] = new_task.get("lat")
        new_composite_task["lng"] = new_task.get("lng")
        mission_table["composite_tasks"].append(new_composite_task)
# Author: Johan Hanssen Seferidis
# License: MIT
import sys
import struct
from base64 import b64encode
from hashlib import sha1
import logging
from socket import error as SocketError
import errno
if sys.version_info[0] < 3:
    from SocketServer import ThreadingMixIn, TCPServer, StreamRequestHandler
else:
    from socketserver import ThreadingMixIn, TCPServer, StreamRequestHandler
logger = logging.getLogger(__name__)
logging.basicConfig()
'''
+-+-+-+-+-------+-+-------------+-------------------------------+
 0                   1                   2                   3
 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1
+-+-+-+-+-------+-+-------------+-------------------------------+
|F|R|R|R| opcode|M| Payload len |    Extended payload length    |
|I|S|S|S|  (4)  |A|     (7)     |             (16/64)           |
|N|V|V|V|       |S|             |   (if payload len==126/127)   |
| |1|2|3|       |K|             |                               |
+-+-+-+-+-------+-+-------------+ - - - - - - - - - - - - - - - +
|     Extended payload length continued, if payload len == 127  |
+ - - - - - - - - - - - - - - - +-------------------------------+
|                     Payload Data continued ...                |
+---------------------------------------------------------------+
'''
FIN    = 0x80
OPCODE = 0x0f
MASKED = 0x80
PAYLOAD_LEN = 0x7f
PAYLOAD_LEN_EXT16 = 0x7e
PAYLOAD_LEN_EXT64 = 0x7f
OPCODE_CONTINUATION = 0x0
OPCODE_TEXT         = 0x1
OPCODE_BINARY       = 0x2
OPCODE_CLOSE_CONN   = 0x8
OPCODE_PING         = 0x9
OPCODE_PONG         = 0xA
# -------------------------------- API ---------------------------------
class API():
    def run_forever(self):
        try:
            logger.info("Listening on port %d for clients.." % self.port)
            self.serve_forever()
        except KeyboardInterrupt:
            self.server_close()
            logger.info("Server terminated.")
        except Exception as e:
            logger.error(str(e), exc_info=True)
            exit(1)
    def new_client(self, client, server):
        pass
    def client_left(self, client, server):
        pass
    def message_received(self, client, server, message):
        pass
    def set_fn_new_client(self, fn):
        self.new_client = fn
    def set_fn_client_left(self, fn):
        self.client_left = fn
    def set_fn_message_received(self, fn):
        self.message_received = fn
    def send_message(self, client, msg):
        self._unicast_(client, msg)
    def send_message_to_all(self, msg):
        self._multicast_(msg)
# ------------------------- Implementation -----------------------------
class WebsocketServer(ThreadingMixIn, TCPServer, API):
    """
	A websocket server waiting for clients to connect.
    Args:
        port(int): Port to bind to
        host(str): Hostname or IP to listen for connections. By default 127.0.0.1
            is being used. To accept connections from any client, you should use
            0.0.0.0.
        loglevel: Logging level from logging module to use for logging. By default
            warnings and errors are being logged.
    Properties:
        clients(list): A list of connected clients. A client is a dictionary
            like below.
                {
                 'id'      : id,
                 'handler' : handler,
                 'address' : (addr, port)
                }
    """
    allow_reuse_address = True
    daemon_threads = True  # comment to keep threads alive until finished
    clients = []
    id_counter = 0
    def __init__(self, port, host='127.0.0.1', loglevel=logging.WARNING):
        logger.setLevel(loglevel)
        TCPServer.__init__(self, (host, port), WebSocketHandler)
        self.port = self.socket.getsockname()[1]
    def _message_received_(self, handler, msg):
        self.message_received(self.handler_to_client(handler), self, msg)
    def _ping_received_(self, handler, msg):
        handler.send_pong(msg)
    def _pong_received_(self, handler, msg):
        pass
    def _new_client_(self, handler):
        self.id_counter += 1
        client = {
            'id': self.id_counter,
            'handler': handler,
            'address': handler.client_address
        }
        self.clients.append(client)
        self.new_client(client, self)
    def _client_left_(self, handler):
        client = self.handler_to_client(handler)
        self.client_left(client, self)
        if client in self.clients:
            self.clients.remove(client)
    def _unicast_(self, to_client, msg):
        to_client['handler'].send_message(msg)
    def _multicast_(self, msg):
        for client in self.clients:
            self._unicast_(client, msg)
    def handler_to_client(self, handler):
        for client in self.clients:
            if client['handler'] == handler:
                return client
class WebSocketHandler(StreamRequestHandler):
    def __init__(self, socket, addr, server):
        self.server = server
        StreamRequestHandler.__init__(self, socket, addr, server)
    def setup(self):
        StreamRequestHandler.setup(self)
        self.keep_alive = True
        self.handshake_done = False
        self.valid_client = False
    def handle(self):
        while self.keep_alive:
            if not self.handshake_done:
                self.handshake()
            elif self.valid_client:
                self.read_next_message()
    def read_bytes(self, num):
        # python3 gives ordinal of byte directly
        bytes = self.rfile.read(num)
        if sys.version_info[0] < 3:
            return map(ord, bytes)
        else:
            return bytes
    def read_next_message(self):
        try:
            b1, b2 = self.read_bytes(2)
        except SocketError as e:  # to be replaced with ConnectionResetError for py3
            if e.errno == errno.ECONNRESET:
                logger.info("Client closed connection.")
                print("Error: {}".format(e))
                self.keep_alive = 0
                return
            b1, b2 = 0, 0
        except ValueError as e:
            b1, b2 = 0, 0
        fin    = b1 & FIN
        opcode = b1 & OPCODE
        masked = b2 & MASKED
        payload_length = b2 & PAYLOAD_LEN
        if opcode == OPCODE_CLOSE_CONN:
            logger.info("Client asked to close connection.")
            self.keep_alive = 0
            return
        if not masked:
            logger.warn("Client must always be masked.")
            self.keep_alive = 1
            return
        if opcode == OPCODE_CONTINUATION:
            logger.warn("Continuation frames are not supported.")
            return
        elif opcode == OPCODE_BINARY:
            logger.warn("Binary frames are not supported.")
            return
        elif opcode == OPCODE_TEXT:
            opcode_handler = self.server._message_received_
        elif opcode == OPCODE_PING:
            opcode_handler = self.server._ping_received_
        elif opcode == OPCODE_PONG:
            opcode_handler = self.server._pong_received_
        else:
            logger.warn("Unknown opcode %#x." % opcode)
            self.keep_alive = 0
            return
        if payload_length == 126:
            payload_length = struct.unpack(">H", self.rfile.read(2))[0]
        elif payload_length == 127:
            payload_length = struct.unpack(">Q", self.rfile.read(8))[0]
        masks = self.read_bytes(4)
        message_bytes = bytearray()
        for message_byte in self.read_bytes(payload_length):
            message_byte ^= masks[len(message_bytes) % 4]
            message_bytes.append(message_byte)
        opcode_handler(self, message_bytes.decode('utf8'))
    def send_message(self, message):
        self.send_text(message)
    def send_pong(self, message):
        self.send_text(message, OPCODE_PONG)
    def send_text(self, message, opcode=OPCODE_TEXT):
        """
        Important: Fragmented(=continuation) messages are not supported since
        their usage cases are limited - when we don't know the payload length.
        """
        # Validate message
        if isinstance(message, bytes):
            message = try_decode_UTF8(message)  # this is slower but ensures we have UTF-8
            if not message:
                logger.warning("Can\'t send message, message is not valid UTF-8")
                return False
        elif sys.version_info < (3,0) and (isinstance(message, str) or isinstance(message, unicode)):
            pass
        elif isinstance(message, str):
            pass
        else:
            logger.warning('Can\'t send message, message has to be a string or bytes. Given type is %s' % type(message))
            return False
        header  = bytearray()
        payload = encode_to_UTF8(message)
        payload_length = len(payload)
        # Normal payload
        if payload_length <= 125:
            header.append(FIN | opcode)
            header.append(payload_length)
        # Extended payload
        elif payload_length >= 126 and payload_length <= 65535:
            header.append(FIN | opcode)
            header.append(PAYLOAD_LEN_EXT16)
            header.extend(struct.pack(">H", payload_length))
        # Huge extended payload
        elif payload_length < 18446744073709551616:
            header.append(FIN | opcode)
            header.append(PAYLOAD_LEN_EXT64)
            header.extend(struct.pack(">Q", payload_length))
        else:
            raise Exception("Message is too big. Consider breaking it into chunks.")
            return
        self.request.send(header + payload)
    def read_http_headers(self):
        headers = {}
        # first line should be HTTP GET
        http_get = self.rfile.readline().decode().strip()
        assert http_get.upper().startswith('GET')
        # remaining should be headers
        while True:
            header = self.rfile.readline().decode().strip()
            if not header:
                break
            head, value = header.split(':', 1)
            headers[head.lower().strip()] = value.strip()
        return headers
    def handshake(self):
        headers = self.read_http_headers()
        try:
            assert headers['upgrade'].lower() == 'websocket'
        except AssertionError:
            self.keep_alive = False
            return
        try:
            key = headers['sec-websocket-key']
        except KeyError:
            logger.warning("Client tried to connect but was missing a key")
            self.keep_alive = False
            return
        response = self.make_handshake_response(key)
        self.handshake_done = self.request.send(response.encode())
        self.valid_client = True
        self.server._new_client_(self)
    @classmethod
    def make_handshake_response(cls, key):
        return \
          'HTTP/1.1 101 Switching Protocols\r\n'\
          'Upgrade: websocket\r\n'              \
          'Connection: Upgrade\r\n'             \
          'Sec-WebSocket-Accept: %s\r\n'        \
          '\r\n' % cls.calculate_response_key(key)
    @classmethod
    def calculate_response_key(cls, key):
        GUID = '258EAFA5-E914-47DA-95CA-C5AB0DC85B11'
        hash = sha1(key.encode() + GUID.encode())
        response_key = b64encode(hash.digest()).strip()
        return response_key.decode('ASCII')
    def finish(self):
        self.server._client_left_(self)
def encode_to_UTF8(data):
    try:
        return data.encode('UTF-8')
    except UnicodeEncodeError as e:
        logger.error("Could not encode data to UTF-8 -- %s" % e)
        return False
    except Exception as e:
        raise(e)
        return False
def try_decode_UTF8(data):
    try:
        return data.decode('utf-8')
    except UnicodeDecodeError:
        return False
    except Exception as e:
        raise(e)
import os, sys, inspect, ast, time, threading
import webbrowser
import SimpleHTTPServer
import SocketServer
#os.chdir("web")
class CombiServer(WebsocketServer, object):
	def __init__(self, http_port, websocket_port):
		super(CombiServer, self).__init__(websocket_port)
		self.websocket_thread = threading.Thread(target=self.run_forever)
		# just serve index.html from current working directory
		#Handler = http.server.SimpleHTTPRequestHandler
		self.http_port = http_port
		#self.httpd = http.server.HTTPServer(("", http_port), Handler)
		#self.http_thread = threading.Thread(target=self.httpd.serve_forever)
		Handler = SimpleHTTPServer.SimpleHTTPRequestHandler
		self.httpd = SocketServer.TCPServer(("", http_port), Handler)
		self.http_thread = threading.Thread(target=self.httpd.serve_forever)
	# Called for every client connecting (after handshake)
	@staticmethod
	def new_client(client, server):
		print("New client connected and was given id %d" % client['id'])
		#server.send_message_to_all("Hey all, a new client has joined us")
	@staticmethod
	# Called for every client disconnecting
	def client_left(client, server):
		print("Client(%d) disconnected" % client['id'])
	@staticmethod
	# Called when a client sends a message
	def message_received(client, server, message):
		print("Client(%d) said:" %client['id'])
		try:
			lines = ast.literal_eval(message)
			for line in lines:
				print(line)
		except:
			print("couldn't understand message")
			print(message)
	def __enter__(self):
		self.websocket_thread.start()
		self.http_thread.start()
		webbrowser.open("http://localhost:%i" %self.http_port) #maybe insert sleep before
	def __exit__(self,*args):
		self.shutdown()
		self.httpd.shutdown()
		self.websocket_thread.join()
		self.http_thread.join()
"""
export ROS_IP=10.0.0.10
export ROS_HOSTNAME=10.0.0.10
export ROS_MASTER_URI=http://10.0.0.10:11311
roscore
ROS_Master_Node_Process.terminate()
"""
from std_msgs.msg import String
import subprocess
import threading
import rospy
import time
import json
def runtime_engine_master(server):
    #subprocess.Popen("export ROS_IP=10.0.0.10", shell=True).wait()
    #subprocess.Popen("export ROS_HOSTNAME=10.0.0.10", shell=True).wait()
    #subprocess.Popen("export ROS_MASTER_URI=http://10.0.0.10:11311", shell=True).wait()
    #ROS_Master_Node_Process = subprocess.Popen(["roscore"])
    rospy.init_node('Master', anonymous=True)
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
        server.send_message_to_all(json.dumps(robot_sensor_data_master))
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
"""
    @end Backend Part 1
"""

task_definitions = {
	"composite_tasks": [
	{
		"composite_task_name" : "Play_Ball",
		"tasks": [
		{
			"task_name" : "defend_goal",
			"actions" : [
			{
				"action_name" : "goTo",
				"action_status" : "not_doing",
				"positioning_action" : "True",
			},
			{
				"action_name" : "moveToGoal",
				"action_status" : "not_doing",
				"positioning_action" : "False",
			},
			{
				"action_name" : "faceBall",
				"action_status" : "not_doing",
				"positioning_action" : "False",
				"action_id" : "1"
			},
			]
		},
		{
			"task_name" : "shot_ball",
			"actions" : [
			{
				"action_name" : "goTo",
				"action_status" : "not_doing",
				"positioning_action" : "True",
			},
			{
				"action_name" : "moveToBall",
				"action_status" : "not_doing",
				"positioning_action" : "False",
			},
			{
				"action_name" : "aim",
				"action_status" : "not_doing",
				"positioning_action" : "False",
			},
			{
				"action_name" : "kickBall",
				"action_status" : "not_doing",
				"positioning_action" : "False",
				"after_action" : "1"
			},
			]
		},
		]
	},
	{
		"composite_task_name" : "Entertain_Humans",
		"tasks": [
		{
			"task_name" : "dance",
			"actions" : [
			{
				"action_name" : "goTo",
				"action_status" : "not_doing",
				"positioning_action" : "True",
			},
			{
				"action_name" : "turnLeft",
				"action_status" : "not_doing",
				"positioning_action" : "False",
			},
			{
				"action_name" : "turnLeft",
				"action_status" : "not_doing",
				"positioning_action" : "False",
			},
			]
		},
		{
			"task_name" : "dance",
			"actions" : [
			{
				"action_name" : "goTo",
				"action_status" : "not_doing",
				"positioning_action" : "True",
			},
			{
				"action_name" : "turnRight",
				"action_status" : "not_doing",
				"positioning_action" : "False",
			},
			{
				"action_name" : "turnRight",
				"action_status" : "not_doing",
				"positioning_action" : "False",
			},
			]
		},
		]
	},
	]
}
			    
"""
    @start Backend Part 2
"""
if __name__ == '__main__':
    try:
        main()
    except rospy.ROSInterruptException:
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
    @end Backend Part 2
"""

