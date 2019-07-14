package baseclass;

import java.io.*;
import java.util.*;

public class PropertyReader {
	
	
	
		public static String PropertiesfilePath = System.getProperty("user.dir") +"\\Environmentconfig.properties";
		
		
	    public static String readApplicationFile(String key){ 
	    	String value = "";
	        try{         	  
		          Properties prop = new Properties();
		          File f = new File(PropertiesfilePath);
		        
		          if(f.exists()){
			          prop.load(new FileInputStream(f));
			          value = prop.getProperty(key); 		        
	          	}
	        }
	        catch(Exception e){  
	           System.out.println("Failed to read from application.properties file.");  
	        }

	        return value;
	     } 
	   
	 
	}


