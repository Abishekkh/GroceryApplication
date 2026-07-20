package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constant;

public class GroceryUtilitiesExcel {
	
	static FileInputStream f; // used to read the Excel File 
	static XSSFWorkbook w; // Represents the entire Excel Workbook
	static XSSFSheet s; // Represents the specific sheet in the Excel Workbook
	
	public static String getStringData(int a, int b, String sheet) throws IOException
	{
//		f = new FileInputStream("C:\\Users\\abhis\\eclipse-workspace2\\GroceryApplication\\src\\test\\resources\\groceryMainProject.xlsx");
		
		f = new FileInputStream(Constant.EXCELPATH); // path shortcut using Constant class in Constant package
		w = new XSSFWorkbook(f);
		s = w.getSheet(sheet);
		XSSFRow r = s.getRow(a);
		XSSFCell c = r.getCell(b);
		return c.getStringCellValue();
	}

	public static int getIntegerData(int a, int b, String sheet) throws IOException
	{
		f = new FileInputStream("C:\\Users\\abhis\\eclipse-workspace2\\GroceryApplication\\src\\test\\resources\\groceryMainProject.xlsx");
		w = new XSSFWorkbook(f);
		s = w.getSheet(sheet);
		XSSFRow r = s.getRow(a);
		XSSFCell c = r.getCell(b);
		int x = (int) c.getNumericCellValue();
		return x;
	}

}
