/**
 * generated by Xtext 2.13.0
 */
package org.xtext.tdl.generator;

import com.google.common.collect.Iterables;
import helperMethods.HelperMethods;
import java.util.ArrayList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.xtext.tdl.tdl.Argument;
import org.xtext.tdl.tdl.CompositeTask;
import org.xtext.tdl.tdl.InitializationModule;
import org.xtext.tdl.tdl.Parameter;
import org.xtext.tdl.tdl.ParameterList;
import org.xtext.tdl.tdl.PublishedData;
import org.xtext.tdl.tdl.Robot;
import org.xtext.tdl.tdl.RosNode;
import org.xtext.tdl.tdl.SimpleAction;
import org.xtext.tdl.tdl.SimpleActionReference;
import org.xtext.tdl.tdl.Task;
import org.xtext.tdl.tdl.Topic;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class TdlGenerator extends AbstractGenerator {
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    Iterable<Robot> _filter = Iterables.<Robot>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), Robot.class);
    for (final Robot robot : _filter) {
      {
        EList<RosNode> _rosNodes = robot.getRosNodes();
        for (final RosNode rosNode : _rosNodes) {
          {
            String _nodeName = rosNode.getNodeName();
            boolean _tripleEquals = (_nodeName == null);
            if (_tripleEquals) {
              final String generated_string = this.generate_ros_node(rosNode).toString();
              final ArrayList<String> generated_string_without_tabs = HelperMethods.removeLeadingTabs(generated_string);
              String _name = robot.getName();
              String _plus = ("/" + _name);
              String _plus_1 = (_plus + "/");
              String _name_1 = robot.getName();
              String _plus_2 = (_plus_1 + _name_1);
              String _plus_3 = (_plus_2 + "_");
              String _name_2 = rosNode.getName();
              String _plus_4 = (_plus_3 + _name_2);
              String _plus_5 = (_plus_4 + ".py");
              fsa.generateFile(_plus_5, this.generate_robot_files_from_string(generated_string_without_tabs));
            }
            if (((rosNode.getNodeName() != null) && (rosNode.getParameterList() != null))) {
              final String generated_string_2 = this.generate_yaml_file(rosNode).toString();
              final ArrayList<String> generated_string_2_without_tabs = HelperMethods.format_yaml_file(generated_string_2);
              String _name_3 = robot.getName();
              String _plus_6 = ("/" + _name_3);
              String _plus_7 = (_plus_6 + "/");
              String _nodeName_1 = rosNode.getNodeName();
              String _plus_8 = (_plus_7 + _nodeName_1);
              String _plus_9 = (_plus_8 + ".yaml");
              fsa.generateFile(_plus_9, this.generate_robot_files_from_string(generated_string_2_without_tabs));
            }
          }
        }
        String _name = robot.getName();
        String _plus = ("/" + _name);
        String _plus_1 = (_plus + "/");
        String _name_1 = robot.getName();
        String _plus_2 = (_plus_1 + _name_1);
        String _plus_3 = (_plus_2 + ".launch");
        fsa.generateFile(_plus_3, this.generate_launch_file(robot));
        String _name_2 = robot.getName();
        String _plus_4 = ("/" + _name_2);
        String _plus_5 = (_plus_4 + "/");
        String _name_3 = robot.getName();
        String _plus_6 = (_plus_5 + _name_3);
        String _plus_7 = (_plus_6 + "_startup.py");
        fsa.generateFile(_plus_7, this.generate_startup_file(robot));
        final String generated_string = this.generate_task_allocation_module(robot).toString();
        final ArrayList<String> generated_string_without_tabs = HelperMethods.removeLeadingTabs(generated_string);
        String _name_4 = robot.getName();
        String _plus_8 = ("/" + _name_4);
        String _plus_9 = (_plus_8 + "/");
        String _name_5 = robot.getName();
        String _plus_10 = (_plus_9 + _name_5);
        String _plus_11 = (_plus_10 + "_task_allocation_module.py");
        fsa.generateFile(_plus_11, this.generate_robot_files_from_string(generated_string_without_tabs));
      }
    }
    int task_nr = 0;
    Iterable<CompositeTask> _filter_1 = Iterables.<CompositeTask>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), CompositeTask.class);
    for (final CompositeTask task : _filter_1) {
      task_nr++;
    }
    if ((task_nr > 0)) {
      fsa.generateFile("/index.html", this.generate_web_interface(resource));
    }
  }
  
  public CharSequence generate_task_allocation_module(final Robot robot) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.newLine();
      {
        InitializationModule _initializationModule = robot.getInitializationModule();
        boolean _tripleNotEquals = (_initializationModule != null);
        if (_tripleNotEquals) {
          _builder.append("\t\t");
          String _codeBlock = robot.getInitializationModule().getCodeBlock();
          _builder.append(_codeBlock);
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      {
        EList<SimpleAction> _simpleActions = robot.getSimpleActions();
        for(final SimpleAction action : _simpleActions) {
          {
            String _positional = action.getPositional();
            boolean _tripleEquals = (_positional == null);
            if (_tripleEquals) {
              _builder.append("\t\t");
              _builder.append("def ");
              String _name = action.getName();
              _builder.append(_name, "\t\t");
              _builder.append("(");
              {
                EList<Parameter> _parameters = action.getParameters();
                boolean _tripleNotEquals_1 = (_parameters != null);
                if (_tripleNotEquals_1) {
                  {
                    EList<Parameter> _parameters_1 = action.getParameters();
                    boolean _hasElements = false;
                    for(final Parameter parameter : _parameters_1) {
                      if (!_hasElements) {
                        _hasElements = true;
                      } else {
                        _builder.appendImmediate(",", "\t\t");
                      }
                      String _name_1 = parameter.getName();
                      _builder.append(_name_1, "\t\t");
                    }
                  }
                }
              }
              _builder.append("):");
              _builder.newLineIfNotEmpty();
            }
          }
          {
            String _positional_1 = action.getPositional();
            boolean _tripleNotEquals_2 = (_positional_1 != null);
            if (_tripleNotEquals_2) {
              _builder.append("\t\t");
              _builder.append("def ");
              String _name_2 = action.getName();
              _builder.append(_name_2, "\t\t");
              _builder.append("(lat,lng):");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t\t");
          _builder.append("\t\t", "\t\t");
          String _codeBlock_1 = action.getCodeBlock();
          _builder.append(_codeBlock_1, "\t\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t");
      _builder.newLine();
      {
        ArrayList<String> __codeLines_from_file = HelperMethods.get_codeLines_from_file("Task Allocation Module Part 1", "/modules/task_allocation_module.py");
        for(final String line : __codeLines_from_file) {
          _builder.append("\t\t");
          _builder.append(line, "\t\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("robot_sensor_data_topic.publish(json.dumps(my_sensor_data))");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      {
        ArrayList<String> __codeLines_from_file_1 = HelperMethods.get_codeLines_from_file("Task Allocation Module Part 2", "/modules/task_allocation_module.py");
        for(final String line_1 : __codeLines_from_file_1) {
          _builder.append("\t\t");
          _builder.append(line_1, "\t\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("my_sensor_data = {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("\"robot_id\": \"");
      String _name_3 = robot.getName();
      _builder.append(_name_3, "\t\t\t\t");
      _builder.append("\",");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t        ");
      _builder.append("\"topics\": [");
      _builder.newLine();
      {
        PublishedData _publishedData = robot.getPublishedData();
        boolean _tripleNotEquals_3 = (_publishedData != null);
        if (_tripleNotEquals_3) {
          {
            EList<Topic> _topics = robot.getPublishedData().getTopics();
            for(final Topic topic : _topics) {
              _builder.append("\t\t        ");
              _builder.append("{");
              _builder.newLine();
              _builder.append("\t\t        ");
              _builder.append("  ");
              _builder.append("\"topic_name\" : \"");
              String _name_4 = topic.getName();
              _builder.append(_name_4, "\t\t          ");
              _builder.append("\",");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t        ");
              _builder.append("  ");
              _builder.append("\"topic_value\" : \"0\"");
              _builder.newLine();
              _builder.append("\t\t        ");
              _builder.append("},");
              _builder.newLine();
            }
          }
        }
      }
      _builder.append("\t\t        ");
      _builder.append("]");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      {
        PublishedData _publishedData_1 = robot.getPublishedData();
        boolean _tripleNotEquals_4 = (_publishedData_1 != null);
        if (_tripleNotEquals_4) {
          {
            EList<Topic> _topics_1 = robot.getPublishedData().getTopics();
            for(final Topic topic_1 : _topics_1) {
              _builder.append("\t\t");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("def ");
              String _name_5 = topic_1.getName();
              _builder.append(_name_5, "\t\t");
              _builder.append("_callback(sensor_value_json):");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append("sensor_value = json.loads(sensor_value_json.data)");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append("for topic in my_sensor_data[\"topics\"]:");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t\t");
              _builder.append("if topic.get(\"topic_name\") == \"");
              String _name_6 = topic_1.getName();
              _builder.append(_name_6, "\t\t\t\t");
              _builder.append("\":");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("\t\t\t");
              _builder.append("topic[\"topic_value\"] = sensor_value");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("rospy.Subscriber(\"");
              String _name_7 = robot.getName();
              _builder.append(_name_7, "\t\t");
              _builder.append("/");
              String _topic = topic_1.getTopic();
              _builder.append(_topic, "\t\t");
              _builder.append("\", String, ");
              String _name_8 = topic_1.getName();
              _builder.append(_name_8, "\t\t");
              _builder.append("_callback)");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.newLine();
            }
          }
        }
      }
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("my_actions_table = {");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("\"actions\": [");
      _builder.newLine();
      {
        EList<SimpleAction> _simpleActions_1 = robot.getSimpleActions();
        for(final SimpleAction action_1 : _simpleActions_1) {
          _builder.append("\t\t        ");
          _builder.append("{");
          _builder.newLine();
          _builder.append("\t\t        ");
          _builder.append("  ");
          _builder.append("\"action_name\" : \"");
          String _name_9 = action_1.getName();
          _builder.append(_name_9, "\t\t          ");
          _builder.append("\",");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t        ");
          _builder.append("  ");
          _builder.append("\"action_status\" : \"not_doing\"");
          _builder.newLine();
          _builder.append("\t\t        ");
          _builder.append("},");
          _builder.newLine();
        }
      }
      _builder.append("\t\t        ");
      _builder.append("]");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("robot_status_table = {");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("\"robot_id\": \"");
      String _name_10 = robot.getName();
      _builder.append(_name_10, "\t\t        ");
      _builder.append("\",");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t        ");
      _builder.append("\"ip_address\": \"0\",");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("\"recovering\": \"0\",");
      _builder.newLine();
      _builder.append("\t\t        ");
      _builder.append("\"recovered_from_task_with_id\": \"0\"");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("robot_sensor_data_topic = rospy.Publisher(\'sensor_data\', String, queue_size=10)");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      {
        ArrayList<String> __codeLines_from_file_2 = HelperMethods.get_codeLines_from_file("Task Allocation Module Part 3", "/modules/task_allocation_module.py");
        for(final String line_2 : __codeLines_from_file_2) {
          _builder.append("\t\t");
          _builder.append(line_2, "\t\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t    ");
      _builder.newLine();
      {
        ArrayList<String> __codeLines_from_file_3 = HelperMethods.get_codeLines_from_file("Task Allocation Module Part 4", "/modules/task_allocation_module.py");
        for(final String line_3 : __codeLines_from_file_3) {
          _builder.append("\t\t");
          _builder.append(line_3, "\t\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      return _builder;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public CharSequence generate_robot_files_from_string(final ArrayList<String> lines) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final String line : lines) {
        _builder.append(line);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence generate_ros_node(final RosNode rosNode) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t\t");
    String _codeBlock = rosNode.getCodeBlock();
    _builder.append(_codeBlock);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generate_launch_file(final Robot robot) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("<launch>");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("<group ns=\"");
    String _name = robot.getName();
    _builder.append(_name, "    ");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    {
      EList<RosNode> _rosNodes = robot.getRosNodes();
      for(final RosNode rosNode : _rosNodes) {
        {
          String _nodeName = rosNode.getNodeName();
          boolean _tripleEquals = (_nodeName == null);
          if (_tripleEquals) {
            _builder.append("\t\t");
            _builder.append("<node pkg=\"multi-robot-simulation\" type=\"");
            String _name_1 = robot.getName();
            _builder.append(_name_1, "\t\t");
            _builder.append("_");
            String _name_2 = rosNode.getName();
            _builder.append(_name_2, "\t\t");
            _builder.append(".py\" name=\"");
            String _name_3 = robot.getName();
            _builder.append(_name_3, "\t\t");
            _builder.append("_");
            String _name_4 = rosNode.getName();
            _builder.append(_name_4, "\t\t");
            _builder.append("\" output=\"screen\">");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("<remap from=\"/tf\" to=\"/");
            String _name_5 = robot.getName();
            _builder.append(_name_5, "\t\t\t");
            _builder.append("/tf\" />");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("</node>");
            _builder.newLine();
          }
        }
        {
          String _nodeName_1 = rosNode.getNodeName();
          boolean _tripleNotEquals = (_nodeName_1 != null);
          if (_tripleNotEquals) {
            _builder.append("\t\t");
            _builder.append("<node pkg=\"");
            String _name_6 = rosNode.getName();
            _builder.append(_name_6, "\t\t");
            _builder.append("\" type=\"");
            String _nodeType = rosNode.getNodeType();
            _builder.append(_nodeType, "\t\t");
            _builder.append("\" name=\"");
            String _nodeName_2 = rosNode.getNodeName();
            _builder.append(_nodeName_2, "\t\t");
            _builder.append("\" output=\"screen\" ");
            {
              String _nodeArgs = rosNode.getNodeArgs();
              boolean _tripleNotEquals_1 = (_nodeArgs != null);
              if (_tripleNotEquals_1) {
                _builder.append(" args=\"");
                String _nodeArgs_1 = rosNode.getNodeArgs();
                _builder.append(_nodeArgs_1, "\t\t");
                _builder.append("\"");
              }
            }
            _builder.append(" >");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("<remap from=\"/tf\" to=\"/");
            String _name_7 = robot.getName();
            _builder.append(_name_7, "\t\t\t");
            _builder.append("/tf\" />");
            _builder.newLineIfNotEmpty();
            {
              ParameterList _parameterList = rosNode.getParameterList();
              boolean _tripleNotEquals_2 = (_parameterList != null);
              if (_tripleNotEquals_2) {
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("<rosparam file=\"$(find multi-robot-simulation)/src/");
                String _name_8 = robot.getName();
                _builder.append(_name_8, "\t\t\t");
                _builder.append("/");
                String _nodeName_3 = rosNode.getNodeName();
                _builder.append(_nodeName_3, "\t\t\t");
                _builder.append(".yaml\" command=\"load\" />");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t\t");
            _builder.append("</node> ");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("</group>");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("<node pkg=\"multi-robot-simulation\" type=\"");
    String _name_9 = robot.getName();
    _builder.append(_name_9, "    ");
    _builder.append("_task_allocation_module.py\" name=\"");
    String _name_10 = robot.getName();
    _builder.append(_name_10, "    ");
    _builder.append("_task_allocation_module\" output=\"screen\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</node>");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("</launch>");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generate_startup_file(final Robot robot) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("SERVER_IP_ADDRESS = \"localhost\"");
    _builder.newLine();
    _builder.append("import time");
    _builder.newLine();
    _builder.append("import subprocess");
    _builder.newLine();
    _builder.append("robot_status_table = {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("\"robot_id\": \"");
    String _name = robot.getName();
    _builder.append(_name, "        ");
    _builder.append("\",");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("\"ip_address\": \"0\",");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t    ");
    _builder.newLine();
    _builder.append("\t\t\t    ");
    _builder.newLine();
    _builder.append("def get_ros_master_ip_address_from_server():");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("server_response = None");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("ws = None");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("while server_response == None:");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("try:");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("import json");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("import sys, ast, math");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("from websocket import create_connection");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("ws = create_connection(\"ws://\" + SERVER_IP_ADDRESS + \":9001/\")");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("ws.send(json.dumps([\"0\", robot_status_table.get(\"robot_id\"), robot_status_table.get(\"robot_ip_address\")]))");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("server_response = ast.literal_eval(ws.recv())");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("except:");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("print(\'\\033[94m\' + robot_status_table.get(\"robot_id\") + \": Trying to Connect to Server\" + \'\\033[0m\')");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("time.sleep(2)");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("finally:");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("if ws != None:");
    _builder.newLine();
    _builder.append("              ");
    _builder.append("ws.close()");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return server_response");
    _builder.newLine();
    _builder.append("\t\t\t    ");
    _builder.newLine();
    _builder.append("\t\t\t    ");
    _builder.newLine();
    _builder.append("if __name__ == \'__main__\':");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("import socket    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("s.connect((\"8.8.8.8\", 80))");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("robot_status_table[\"robot_ip_address\"] = s.getsockname()[0]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("s.close() ");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("message = get_ros_master_ip_address_from_server()");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("subprocess.Popen(\"export ROS_MASTER_URI=http://\" + message[1] + \":11311; export ROS_IP=\" + robot_status_table.get(\"robot_ip_address\") + \"; export ROS_HOSTNAME=\" + robot_status_table.get(\"robot_ip_address\") + \"; roslaunch multi-robot-simulation ");
    String _name_1 = robot.getName();
    _builder.append(_name_1, "    ");
    _builder.append(".launch\", shell=True).wait()");
    _builder.newLineIfNotEmpty();
    _builder.append("    \t      ");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generate_yaml_file(final RosNode rosNode) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("\t\t");
    String _codeBlock = rosNode.getParameterList().getCodeBlock();
    _builder.append(_codeBlock);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generate_web_interface(final Resource resource) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.newLine();
      {
        ArrayList<String> __codeLines_from_file = HelperMethods.get_codeLines_from_file("Index Part 1", "/modules/index.html");
        for(final String line : __codeLines_from_file) {
          _builder.append(line);
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      {
        Iterable<CompositeTask> _filter = Iterables.<CompositeTask>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), CompositeTask.class);
        for(final CompositeTask compositeTask : _filter) {
          _builder.append("<input id=\"");
          String _name = compositeTask.getName();
          _builder.append(_name);
          _builder.append("\" class=\"button_task\" type=\"button\" value=\"");
          String _name_1 = compositeTask.getName();
          _builder.append(_name_1);
          _builder.append("\" onclick=\"setTask(\'");
          String _name_2 = compositeTask.getName();
          _builder.append(_name_2);
          _builder.append("\');\" />");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("<script>");
      _builder.newLine();
      _builder.append("task_definitions = {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("\"composite_tasks\": [");
      _builder.newLine();
      {
        Iterable<CompositeTask> _filter_1 = Iterables.<CompositeTask>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), CompositeTask.class);
        for(final CompositeTask compositeTask_1 : _filter_1) {
          _builder.append("\t\t\t\t\t\t");
          _builder.append("{");
          _builder.newLine();
          _builder.append("\t\t\t\t\t\t");
          _builder.append("\t");
          _builder.append("\"composite_task_name\" : \"");
          String _name_3 = compositeTask_1.getName();
          _builder.append(_name_3, "\t\t\t\t\t\t\t");
          _builder.append("\",");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t\t\t\t");
          _builder.append("\t");
          _builder.append("\"tasks\": [");
          _builder.newLine();
          {
            EList<Task> _tasks = compositeTask_1.getTasks();
            for(final Task task : _tasks) {
              _builder.append("\t\t\t\t\t\t");
              _builder.append("\t");
              _builder.append("{");
              _builder.newLine();
              _builder.append("\t\t\t\t\t\t");
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("\"task_name\" : \"");
              String _name_4 = task.getName();
              _builder.append(_name_4, "\t\t\t\t\t\t\t\t");
              _builder.append("\",");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t\t\t\t\t");
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("\"actions\" : [");
              _builder.newLine();
              {
                EList<SimpleActionReference> _simpleActions = task.getSimpleActions();
                for(final SimpleActionReference simpleAction : _simpleActions) {
                  _builder.append("\t\t\t\t\t\t");
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("{");
                  _builder.newLine();
                  _builder.append("\t\t\t\t\t\t");
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("\"action_name\" : \"");
                  String _name_5 = simpleAction.getName();
                  _builder.append(_name_5, "\t\t\t\t\t\t\t\t\t");
                  _builder.append("\",");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t\t\t\t\t\t");
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("\"action_status\" : \"not_doing\",");
                  _builder.newLine();
                  {
                    String _positional = simpleAction.getPositional();
                    boolean _tripleNotEquals = (_positional != null);
                    if (_tripleNotEquals) {
                      _builder.append("\t\t\t\t\t\t");
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("\"positioning_action\" : \"True\",");
                      _builder.newLine();
                    }
                  }
                  {
                    String _positional_1 = simpleAction.getPositional();
                    boolean _tripleEquals = (_positional_1 == null);
                    if (_tripleEquals) {
                      _builder.append("\t\t\t\t\t\t");
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("\"positioning_action\" : \"False\",");
                      _builder.newLine();
                    }
                  }
                  {
                    String _id = simpleAction.getId();
                    boolean _tripleNotEquals_1 = (_id != null);
                    if (_tripleNotEquals_1) {
                      _builder.append("\t\t\t\t\t\t");
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("\"action_id\" : \"");
                      String _id_1 = simpleAction.getId();
                      _builder.append(_id_1, "\t\t\t\t\t\t\t\t\t");
                      _builder.append("\",");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                  {
                    int _sync = simpleAction.getSync();
                    boolean _tripleNotEquals_2 = (_sync != 0);
                    if (_tripleNotEquals_2) {
                      _builder.append("\t\t\t\t\t\t");
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("\"sync_number\" : \"");
                      int _sync_1 = simpleAction.getSync();
                      _builder.append(_sync_1, "\t\t\t\t\t\t\t\t\t");
                      _builder.append("\",");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                  {
                    String _after = simpleAction.getAfter();
                    boolean _tripleNotEquals_3 = (_after != null);
                    if (_tripleNotEquals_3) {
                      _builder.append("\t\t\t\t\t\t");
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("\"after_action\" : \"");
                      String _after_1 = simpleAction.getAfter();
                      _builder.append(_after_1, "\t\t\t\t\t\t\t\t\t");
                      _builder.append("\",");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                  _builder.append("\t\t\t\t\t\t");
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("\"arguments\": [");
                  {
                    EList<Argument> _arguments = simpleAction.getArguments();
                    boolean _hasElements = false;
                    for(final Argument argument : _arguments) {
                      if (!_hasElements) {
                        _hasElements = true;
                      } else {
                        _builder.appendImmediate(",", "\t\t\t\t\t\t\t\t\t");
                      }
                      _builder.append("\"");
                      String _name_6 = argument.getName();
                      _builder.append(_name_6, "\t\t\t\t\t\t\t\t\t");
                      _builder.append("\"");
                    }
                  }
                  _builder.append("],");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t\t\t\t\t\t");
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("},");
                  _builder.newLine();
                }
              }
              _builder.append("\t\t\t\t\t\t");
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("]");
              _builder.newLine();
              _builder.append("\t\t\t\t\t\t");
              _builder.append("\t");
              _builder.append("},");
              _builder.newLine();
            }
          }
          _builder.append("\t\t\t\t\t\t");
          _builder.append("\t");
          _builder.append("]");
          _builder.newLine();
          _builder.append("\t\t\t\t\t\t");
          _builder.append("},");
          _builder.newLine();
        }
      }
      _builder.append("\t\t\t\t\t\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("</script>");
      _builder.newLine();
      _builder.newLine();
      {
        ArrayList<String> __codeLines_from_file_1 = HelperMethods.get_codeLines_from_file("Index Part 2", "/modules/index.html");
        for(final String line_1 : __codeLines_from_file_1) {
          _builder.append(line_1);
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      return _builder;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
