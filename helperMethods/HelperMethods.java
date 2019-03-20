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
		  while (codeLine == null || !codeLine.contains("@start " + module)) {
			  codeLine = reader.readLine();
		  }
		  codeLines.add(start_comment);
		  codeLines.add(codeLine);
		  
		  while (codeLine == null || !codeLine.contains("@end " + module)) {
			  codeLine = reader.readLine();
			  if (codeLine != null) {
				  codeLines.add(codeLine);
			  }
		  }
		  codeLines.add(end_comment);
		  
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
	
	
}


