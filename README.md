# Task-Definition-Language

## Description
The Task Definition Language is a domain-specific language for the development of heterogeneous multi-robot systems. It allows you to add your robots to the framework and then create a mission for a team of robots through a web interface. It is built on top of the robot operating system and is using an auction-based task allocation algorithm to distribute tasks amongst the robots.

Setup on simulator requires Linux with ROS installed. Setup on real robots requires Linux with ROS installed on each robot and each robot must have a gps.

<br />

## Eclipse Setup

#### Clone the project:

```
git clone https://github.com/95danlos/Task-Definition-Language.git
```

#### Install Xtext and Xtend:

In the Eclipse menu bar click --> help --> Eclipse Marketplace and search for Xtext and Xtend.

Add the Task-Definition-Language Plugin:

In the Eclipse menu bar click --> help --> install new software --> add --> local --> select the plugin folder in the cloned project, if the plugin is not listed uncheck "Group item by category" --> install the plugin and restart Eclipse.


#### Create a new project:

In Eclipse click --> new project --> general --> project.

Create a new folder call it scr, here you can add a file for each robot and one file defining the tasks.

To add a new robot create a new file under src with the extension .tdl. Click yes when asked to convert to Xtext project.

A robot file should contain an implementation of each simple action that the robot is able to perform, and can also contain implementation of ROS nodes and parameters. See the ROS tutorials for information on how to write ROS nodes http://wiki.ros.org/ROS/Tutorials. 

Create a new .tdl file and define each task that the robots should perform.

Example files for task definitions and simulated robots can be found under multi-robot-simulation/robots.


<br />

## Simulator Setup

Setup on simulator requires ROS. Follow the ROS setup tutorial at http://wiki.ros.org/ROS/Installation.

Install the Gazebo simulator by following the steps at http://gazebosim.org/tutorials?tut=ros_installing.

Move the gazebo models from Task-Definition-Language\multi-robot-simulation\gazebo-models over to ~/.gazebo/models.

Create a catkin workspace by following the steps at http://wiki.ros.org/ROS/Tutorials/InstallingandConfiguringROSEnvironment.

Create a new ROS package called multi-robot-simulation by following the steps at http://wiki.ros.org/ROS/Tutorials/CreatingPackage.

Build the package by following the steps at http://wiki.ros.org/ROS/Tutorials/BuildingPackages.

Copy the files from the folder called multi-robot-simulation in the cloned project over to the newly created package.

Make the src files executable:

```
chmod +x -R ~/catkin_ws/src/multi-robot-simulation/src
```

Install python websocket client: 

```
pip install websocket_client
```

Start the server:

```
python ~/catkin_ws/src/multi-robot-simulation/server.py
```

Launch the simulation:

```
roslaunch multi-robot-simulation multi-robot-simulation.launch
```

Open the index file in ~/catkin_ws/src/multi-robot-simulation.

<br /> 

![alt text](https://github.com/95danlos/Task-Definition-Language/blob/master/images/simulation_demo_img_2.png)


<br />

## Setup on Real Robots

Setup on real robots requires all of the robots to have ROS installed. Follow the ROS setup tutorial at http://wiki.ros.org/ROS/Installation.

Create a catkin workspace: http://wiki.ros.org/ROS/Tutorials/InstallingandConfiguringROSEnvironment.

Create a new ROS package called multi-robot-simulation: http://wiki.ros.org/ROS/Tutorials/CreatingPackage.

Build the package: http://wiki.ros.org/ROS/Tutorials/BuildingPackages.

Add a .tld file for each robot and one for the tasks as described under the Eclipse Setup section above.

Change the SERVER_IP_ADDRESS variable in each generated setup file and in each generated task allocation module file under src-gen to the ip address of the machine that is going to run the server.

Move the src-gen folders for each robot to ~/catkin_ws/src/multi-robot-simulation/src on the appropriate robot.

Run the startup files on each robot, then start the server and open the index file.


<br />

## Maintainer Setup

#### Import to Eclipse:

In Eclipse click --> File --> Import --> Existing Projects into Workspace --> Browse --> select the Task-Definition-Language-Project folder.


#### Install Xtext and Xtend:

In the Eclipse menu bar click --> help --> Eclipse Marketplace and search for Xtext and Xtend.


#### The project org.xtext.tdl contains six files used for development found under src:
 
Tdl.xtext contains the grammar for the task definition language written in Xtext.

TdlGenerator.xtend contains the generator which is used to take information from the robot and task files to create the index file for the web interface, and the task allocation module, launch file, startup file, and ROS files for each robot.

HelperMethods.java contains methods used by the generator to format generated files.

index.html contains the web interface and task definitions.

server.py connects the web interface with the robots and the robots with each other.

task_allocation_module.py is used to distribute tasks amongst the robots and execute actions.





