package helperMethods;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


public class HelperMethods {
	
	
	public static ArrayList<String> get_codeLines_from_file(String module, String file_path) throws Exception {
		  InputStream is = HelperMethods.class.getResourceAsStream(file_path);
		  BufferedReader reader;
		  
		  reader = new BufferedReader(new InputStreamReader(is));
		  ArrayList<String> codeLines = new ArrayList<String>();
		  
		  String start_comment = "\"\"\"";
		  String end_comment = "\"\"\"";
		  if (file_path.contains("html")) {
			  start_comment = "<!--";
			  end_comment = "-->";
		  }
		  
		  String codeLine = "";
		  String lastLine = "";
		  while (codeLine == null || !codeLine.contains("@start " + module)) {
			  if (codeLine != null && codeLine.trim().length() > 0) {
				  lastLine = codeLine;
			  }
			  codeLine = reader.readLine();
		  }
		  String spaces;
		  if (lastLine.length() != lastLine.trim().length()) {
			  spaces = lastLine.split(String.valueOf(lastLine.trim().charAt(0)))[0];
		  }
		  else {
			  spaces = "";
		  }
		  codeLines.add(spaces + start_comment);
		  codeLines.add(codeLine);
		  
		  while (codeLine == null || !codeLine.contains("@end " + module)) {
			  if (codeLine != null && codeLine.trim().length() > 0) {
				  lastLine = codeLine;
			  }
			  codeLine = reader.readLine();
			  if (codeLine != null) {
				  codeLines.add(codeLine);
			  }
		  }
		  if (lastLine.length() != lastLine.trim().length()) {
			  spaces = lastLine.split(String.valueOf(lastLine.trim().charAt(0)))[0];
		  }
		  else {
			  spaces = "";
		  }
		  codeLines.add(spaces + end_comment);
		  
		  reader.close();
		  return codeLines;
	}
	
	
	public static ArrayList<String> removeLeadingTabs(String param) {
		ArrayList<String> lines = new ArrayList<String>();
		Scanner scanner = new Scanner(param);
		lines.add("#!/usr/bin/python");
		while (scanner.hasNextLine()) {
		  String line = scanner.nextLine();
		  String newLine = "";
		  if (line.length() > 2) {
		  	newLine = line.substring(2);
		  }
		  else {
		  	newLine = line;
		  }
		  lines.add(newLine);
		}
		scanner.close();
		return lines;
    }
	
	
	public static ArrayList<String> format_yaml_file(String param) {
		ArrayList<String> lines = new ArrayList<String>();
		Scanner scanner = new Scanner(param);

		while (scanner.hasNextLine()) {
		  String line = scanner.nextLine().trim();
		  String newLine = "";
		  if (line.split(":").length == 1) {
		  	newLine = line;
		  }
		  else {
		  	newLine = " " + line;
		  }
		  lines.add(newLine);
		}
		scanner.close();
		return lines;
    }
	
	
}


