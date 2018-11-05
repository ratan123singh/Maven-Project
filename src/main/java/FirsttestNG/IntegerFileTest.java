package FirsttestNG;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class IntegerFileTest {
	@Test (dataProvider="IntegerData")
	public void add(String num1, String num2, String num3)
	{
		int a = Integer.parseInt(num1);
		int b = Integer.parseInt(num2);
		int c = Integer.parseInt(num3);
		
		int result = a+b+c;
		System.out.println("The addition of the total numbers " +result);
		
	}
	
	@DataProvider (name = "IntegerData")
	public Object [] [] readExcel() throws BiffException, IOException
	{
		File f = new File("C:/Users/Ratan/Desktop/MyexcelSheet.xls");
		Workbook wb = Workbook.getWorkbook(f);
		Sheet s = wb.getSheet("Sheet3");
		
		int rows = s.getRows();
		int columns = s.getColumns();
		System.out.println("The Number of rows are " +rows);
		System.out.println("The number of columns are " +columns);
		
		String inputData [] []= new String [rows] [columns];
		
		for(int i=0; i<rows; i++)
		{
			for(int j=0; j<columns; j++)
			{
				Cell c = s.getCell(i,j);
				inputData[i][j] = c.getContents();
				System.out.println("The number present in the excel sheet " +inputData[i][j]);
				
			}
		}
		return inputData;
		
	}

}
