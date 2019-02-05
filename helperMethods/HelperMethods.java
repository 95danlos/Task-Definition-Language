package helperMethods;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class HelperMethods {
	
	public static ArrayList<String> get_runtime_Engine() throws Exception {		  
		  InputStream is = HelperMethods.class.getResourceAsStream("/runTimeEngine/RunTime_Engine_Slave.py");
		  BufferedReader reader;
		  reader = new BufferedReader(new InputStreamReader(is));
		  
		  String codeLine;
		  ArrayList<String> codeLines = new ArrayList<String>();
		  while ((codeLine = reader.readLine()) != null) {
			  codeLines.add(codeLine);
			  }
		  reader.close();
		  return codeLines;
	}
	
	
	public static ArrayList<String> get_python_backend() throws Exception {		  
		  InputStream is = HelperMethods.class.getResourceAsStream("/runTimeEngine/backend.py");
		  BufferedReader reader;
		  reader = new BufferedReader(new InputStreamReader(is));
		  
		  String codeLine;
		  ArrayList<String> codeLines = new ArrayList<String>();
		  while ((codeLine = reader.readLine()) != null) {
			  codeLines.add(codeLine);
			  }
		  reader.close();
		  return codeLines;
	}
	
	
	public static ArrayList<String> get_first_part_of_web_interface() throws Exception {		  
		  InputStream is = HelperMethods.class.getResourceAsStream("/runTimeEngine/index.html");
		  BufferedReader reader;
		  reader = new BufferedReader(new InputStreamReader(is));
		  
		  ArrayList<String> codeLines = new ArrayList<String>();
		  for (int i = 0; i < 40; i++) {
			  codeLines.add(reader.readLine());
		  }
		  reader.close();
		  return codeLines;
	}
	
	public static ArrayList<String> get_second_part_of_web_interface() throws Exception {		  
		  InputStream is = HelperMethods.class.getResourceAsStream("/runTimeEngine/index.html");
		  BufferedReader reader;
		  reader = new BufferedReader(new InputStreamReader(is));
		  
		  String codeLine;
		  ArrayList<String> codeLines = new ArrayList<String>();
		  for (int i = 0; i < 40; i++) {
			  reader.readLine();
		  }
		  while ((codeLine = reader.readLine()) != null) {
			  codeLines.add(codeLine);
			  }
		  reader.close();
		  return codeLines;
	}
	
	
}


