package utilities;

import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class ReadandParseDocxFile 
{
	
	
	public static Boolean readdocfileParagraph(String filepath, String FindText)
	
	
	{
		boolean flag = false;
	
		try {
			FileInputStream fis = new FileInputStream(filepath);
			
			XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));

			List<XWPFParagraph> paragraphList = xdoc.getParagraphs();
			

			for (XWPFParagraph paragraph : paragraphList)
			
			{

		String test = paragraph.getText().replaceAll("\\s+","");
				
		if (test.contains(FindText)) {
			
			String FindString = paragraph.getText().replaceAll("\\s+","");
System.out.println(FindString);
		 flag = true;
			
		}
		
		
	}
				
		} 
		
		catch (Exception ex) {
			ex.printStackTrace();
			
		}
	
		return flag;		
	}

	
	
	public static boolean readdocfile(String Filepath, String FindText) {
		
		boolean flag = false;
		try {
			   FileInputStream fis = new FileInputStream(Filepath);
			   XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
			   XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
			  // System.out.println(extractor.getText());
			   
			if (extractor.getText().contains(FindText)) {
				
				
			flag = true;
				
			}
			
	
			   
			} 
		catch(Exception ex) {
			
			    ex.printStackTrace();
			}
		
		return flag;
	}
	
	



}


