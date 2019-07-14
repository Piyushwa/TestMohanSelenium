package utilities;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Reporter;

import baseclass.DriverHelper;

public class ExecutionLog {


	public static void Log(String text)
	{
		final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
		System.setProperty(ESCAPE_PROPERTY, "false");

		ExecutionLog executionLog = new ExecutionLog();	
		String dateTime = executionLog.getDate();
		String fileName = executionLog.getFileName();
		try
		{			 
			// Create file 
			FileWriter fstream = new FileWriter(System.getProperty("user.dir")+"\\ExecutionLog\\"+fileName+".txt",true);
			BufferedWriter out = new BufferedWriter(fstream);

			if(text.length()==0) {
				Reporter.log("<html><body><b> \n <br></br></b></html></body>");
				out.write(text);
			} else	if(text.contains("BUG") || text.contains("Failed")) {
				text = dateTime +" [Fail]  "+ text;
				Reporter.log("<html><body><b>||"+DriverHelper.color("red" , text)+"||<br></br></b></html></body>");
				out.write(DriverHelper.color("red" , text));
			} else if(text.contains("Verified")) {  
				text = dateTime +" [Verification]  "+ text;
				out.write(DriverHelper.color("green" , text));
				Reporter.log("<html><body><b>||"+DriverHelper.color("green" , text)+"||<br></br></b></html></body>");

			} else if(text.contains("Manual") || text.contains("Manual Test Step")) {  
				text = text.replace("Manual Test Step", " [Manual Test Step]");
				out.write(DriverHelper.color("blue" , text));
				Reporter.log("<html><body><b>||"+DriverHelper.color("blue" , text)+"||<br></br></b></html></body>");

			} else {
				text = dateTime +" [Info]  "+ text;
				Reporter.log("<html><body><b>||"+text+"||<br></br></b></html></body>");
				out.write(text);
			}

			System.out.println(text);
			out.newLine();

			//Close the output stream
			out.close();		    
		}
		catch (Exception e)
		{ 
			System.err.println("Error: " + e.getMessage()); 
		}


	}

	public  String getFileName()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();		 
		String fileName = "Report-"+dateFormat.format(cal.getTime());
		return fileName;
	}

	public String getDate()
	{
		DateFormat dateFormat = new SimpleDateFormat("MMM dd,yyyy HH:mm:ss");
		Calendar cal = Calendar.getInstance();	
		String dateTime =  dateFormat.format(cal.getTime());
		return dateTime;
	}

}
