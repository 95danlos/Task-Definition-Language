# Task-Definition-Language

## Description
The Task Definition Language is a domain-specific language for the development of heterogeneous multi-robot systems. It allows you to add your robots to the framework and then create a mission for a team of robots through a web interface. It is built on top of the robot operating system and is using an auction-based task allocation algorithm to distribute tasks amongst the robots.


<br />

## Eclipse Setup

Clone the project:

```
git clone https://github.com/95danlos/Task-Definition-Language.git
```

Install Xtext and Xtend:

In the eclipse menu bar click help --> Eclipse Marketplace --> search for xtext --> install Eclipse Xtext and Eclipse Xtend

Add the Task-Definition-Language Plugin:

In the eclipse menu bar click help --> install new software --> add --> local --> select the plugin folder in the cloned project, if the plugin is not listed uncheck "Group item by category" --> install the plugin and restart eclipse


Create a new Eclipse project:

In Eclipse click new project --> General --> Project

Create New folder call it Scr

Create a new file with the extension .tdl --> click yes when asked to convert to Xtext Project

* create a new file for each robot

* Create a new file and add Tasks

* Example files in multi-robot-simulation/robots


<br />

## Simulation Setup

Setup on simulation requires linux and ROS. Follow the ROS setup tutorial at http://wiki.ros.org/ROS/Installation

Then install the Gazebo simulator by following the steps at http://gazebosim.org/tutorials?tut=ros_installing

Move the gazebo models from Task-Definition-Language\multi-robot-simulation\gazebo-models over to ~/.gazebo/models

Create a catkin workspace: http://wiki.ros.org/ROS/Tutorials/InstallingandConfiguringROSEnvironment

Create a new ROS package called multi-robot-simulation: http://wiki.ros.org/ROS/Tutorials/CreatingPackage

Build the package: http://wiki.ros.org/ROS/Tutorials/BuildingPackages

Copy the files form the folder called multi-robot-simulationfrom in the cloned project over to the new created package

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

Open the index file in ~/catkin_ws/src/multi-robot-simulation


<br /> 

![alt text](https://github.com/95danlos/Task-Definition-Language/blob/master/images/simulation_demo_img_2.png)


## Setup on Real Robots





<br />

## Developer Setup





