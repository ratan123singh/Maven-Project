package FirsttestNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Read_Write {

	public static void main(String[] args) throws IOException {

		File src = new File("C://Users//Ratan//Desktop//MyexcelSheet.xls");
		
		FileInputStream fis = new FileInputStream(src);
		
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		
		HSSFSheet sheet = wb.getSheetAt(0);
		
		String data = sheet.getRow(0).getCell(0).getStringCellValue();
		
		System.out.println("Data from excel is "+data);
		
		String data1 = sheet.getRow(0).getCell(1).getStringCellValue();
		
		System.out.println("Data from excel is "+data1);
		
		wb.close();
	}

}
