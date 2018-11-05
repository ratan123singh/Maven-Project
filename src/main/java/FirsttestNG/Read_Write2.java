package FirsttestNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Read_Write2 {

	public static void main(String[] args) throws IOException {

		File src = new File("C://Users//Ratan//Desktop//MyexcelSheet.xls");
		
		FileInputStream fis = new FileInputStream(src);
		
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		
		HSSFSheet sheet = wb.getSheetAt(0);
		
		sheet.getRow(0).createCell(2).setCellValue("Pass");
		
		sheet.getRow(1).createCell(2).setCellValue("Fail");
		
		FileOutputStream fout = new FileOutputStream(src);
		
		wb.write(fout);
		
		
		
		
		
		wb.close();
	}

}
