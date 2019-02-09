package helperMethods;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;


public class HelperMethods {
	
	
	public static ArrayList<String> get_codeLines_from_file(int start_line, int end_line, String file_path) throws Exception {
		  InputStream is = HelperMethods.class.getResourceAsStream(file_path);
		  BufferedReader reader;
		  
		  reader = new BufferedReader(new InputStreamReader(is));
		  ArrayList<String> codeLines = new ArrayList<String>();
		  
		  String codeLine;
		  int current_line = 1;
		  while (current_line < start_line) {
			  reader.readLine();
			  current_line++;
		  }
		  while (current_line < end_line + 1) {
			  codeLine = reader.readLine();
			  if (codeLine == null) {
				  break;
			  }
			  codeLines.add(codeLine);
			  current_line++;
		  }
		  reader.close();
		  return codeLines;
	}
	
	
	public static ArrayList<String> removeLeadingTabs(String param) {
		ArrayList<String> lines = new ArrayList<String>();
		Scanner scanner = new Scanner(param);
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


