package genaricLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	private Workbook wb;
	
	public void excelInitialization(String excelPath)
	{
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(excelPath);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

		try
		{
			wb= WorkbookFactory.create(fis);
		} 
		catch (EncryptedDocumentException | IOException  e)
		{
			e.printStackTrace();
		}
	}
		
		public String readDataFromExcel(String sheetName, int rowNum, int cellNum)
		{
			return wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		}

		public List<String> readDataFromExcel(String SheetName)
		{
			Sheet sh =wb.getSheet(SheetName);
			
			List<String> dataList = new ArrayList<>();
			
			for(int i=0; i<=sh.getLastRowNum(); i++)
			{
				dataList.add (sh.getRow(i).getCell(1).getStringCellValue());
			}
	 
			return dataList;
		}
	
		public void closeExcel()
		{
			try
			{
				wb.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}

		}
	}
