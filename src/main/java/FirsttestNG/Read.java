package FirsttestNG;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Read {

	public static void main(String[] args) throws IOException 
	{
		FileInputStream input = new FileInputStream("C://Users//Ratan//Desktop//MyexcelSheet.xls");
		
		HSSFWorkbook wb = new HSSFWorkbook(input);
		
		HSSFSheet sheet = wb.getSheet("Sheet5");
		
		int totalrow = sheet.getLastRowNum();
		
		String text=sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.println("Total number of rows present in sheet "+text);
		
		double numericvalue = sheet.getRow(1).getCell(0).getNumericCellValue();
		System.out.println(numericvalue);
		
		HSSFCell datevalue = sheet.getRow(2).getCell(0);
		System.out.println(datevalue);
		
		HSSFHyperlink url = sheet.getRow(3).getCell(0).getHyperlink();
		String url2 = url.getAddress();
		System.out.println(url);
		
		System.out.println("---------------------------------------------");
		
		for(int i=0; i<=totalrow; i++)
		{
			HSSFCell result = sheet.getRow(i).getCell(0);
			System.out.println(result);
		}	
	}

}
