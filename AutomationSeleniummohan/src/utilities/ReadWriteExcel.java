package utilities;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.format.CellFormatType;
import org.apache.poi.hssf.usermodel.examples.CellTypes;


public class ReadWriteExcel {

	


		
		
		public static XSSFSheet ExcelWSheet;

		public static XSSFWorkbook ExcelWBook;

		public static XSSFCell Cell;

		//private static XSSFRow Row;
		
		public static void setExcelFile(String Path,String SheetName) throws Exception {

				try {

	   			// Open the Excel file

				FileInputStream ExcelFile = new FileInputStream(Path);

				// Access the required test data sheet

				ExcelWBook = new XSSFWorkbook(ExcelFile);

				ExcelWSheet = ExcelWBook.getSheet(SheetName);

				} catch (Exception e){

					throw (e);

				}

		}

		
		public static int getExcelColumnNumber(String column) {
	        int result = 0;
	        for (int i = 0; i < column.length(); i++) {
	            result *= 26;
	            result += column.charAt(i) - 'A' + 1;
	        }
	        return result;
	    }
		//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

	    public static String getCellData(int RowNum, int ColNum) throws Exception{

				try{
					
					
					
					 DataFormatter formatter = new DataFormatter(); 
	  			Cell = ExcelWSheet.getRow(RowNum-1).getCell(ColNum-1);
	  	
	  		String CellData = formatter.formatCellValue(Cell); 
	  				
	  				//Cell.getStringCellValue();
				
	  			return CellData;
	  			
				}
	  			
	  			catch (Exception e){

					return"No";

	  			}
				    }
	    
	    
	    public static String getCellDataString(int RowNum, String ColName) throws Exception{

					try{
						
				int ColNum = getExcelColumnNumber(ColName);
					  			
						 DataFormatter formatter = new DataFormatter(); 
		  			Cell = ExcelWSheet.getRow(RowNum-1).getCell(ColNum-1);

		  			String CellData = formatter.formatCellValue(Cell); 
		  				//Cell.getStringCellValue();
					
		  			return CellData;
		  			
					}
		  			
		  			catch (Exception e){

						return"No";

		  			}
					    }
	    public static String getCellDatawithoutformula(int RowNum, int ColNum) throws Exception{

					try{
						
						
						
						 DataFormatter formatter = new DataFormatter(); 
		  			Cell = ExcelWSheet.getRow(RowNum-1).getCell(ColNum-1);
		  	
		  		
		  	String CellData = Cell.getRawValue();
		  				
		  			
					
		  			return CellData;
		  			
					}
		  			
		  			catch (Exception e){

						return"No";

		  			}
					    }
		    

	}
