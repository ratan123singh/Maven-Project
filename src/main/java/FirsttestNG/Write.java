package FirsttestNG;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Write {

	public static void main(String[] args) throws IOException 
	{
		FileInputStream input = new FileInputStream("C://Users//Ratan//Desktop//MyexcelSheet.xls");
		
		HSSFWorkbook wb = new HSSFWorkbook(input);
		
		HSSFSheet sheet = wb.getSheet("Sheet5");
		
		sheet.getRow(1).createCell(2).setCellValue("pass");
		sheet.getRow(2).createCell(2).setCellValue("fail");
		sheet.getRow(3).createCell(2).setCellValue("pass");
		sheet.getRow(4).createCell(2).setCellValue("fail");
		
		
		System.out.println("writing excel");
		
		FileOutputStream output = new FileOutputStream("C://Users//Ratan//Desktop//MyexcelSheet.xls");
		
		wb.write(output);
		
		wb.close();
		
	}

}
