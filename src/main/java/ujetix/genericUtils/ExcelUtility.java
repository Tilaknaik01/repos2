 	package ujetix.genericUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	/**
	 * 
	 * to fetch the data from excel
	 * @param sheetName
	 * @param row_index
	 * @param cell_index
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getDataFromExcel(String sheetName, int row_index,int cell_index) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis = new FileInputStream(IPathConstants.excelPath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sh = workbook.getSheet(sheetName);
		Row row = sh.getRow(row_index);
		Cell cell = row.getCell(cell_index);
		DataFormatter format = new DataFormatter();
		return format.formatCellValue(cell);
		
	}
	
	/**
	 * 
	 * to insert the data  into excel sheet
	 * @param sheetName
	 * @param row_index
	 * @param cell_index
	 * @param set_value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void insertDataIntoExcel(String sheetName,int row_index, int cell_index, String set_value) throws EncryptedDocumentException, IOException
	{
	
		FileInputStream fis = new FileInputStream(IPathConstants.excelPath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sh = workbook.getSheet(sheetName);
		Row row = sh.createRow(row_index);
		Cell cell = row.createCell(cell_index);
		cell.setCellValue(set_value);
		FileOutputStream fos = new FileOutputStream(IPathConstants.excelPath);
		workbook.write(fos);
		workbook.close();
		
	}
	
	/**
	 * 
	 * to get the last row number of excel sheet
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis = new FileInputStream(IPathConstants.excelPath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		int lastRowNum = sheet.getLastRowNum();
		return lastRowNum;
	}
	
	

	/**
	 * to fetch multiple data 
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public HashMap<String,String> getmultipledata() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IPathConstants.excelPath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("CreateData_ujetix");// we should specifie the sheet name here
		int lastRow = sh.getLastRowNum();
		
		//System.out.println("Last Row accessing :"+lastRow);
		HashMap<String, String> hashmap = new HashMap<String, String>();
		for (int i = 0; i <=lastRow; i++) 
		{
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			hashmap.put(key, value);//to add the data inside the hashmap
		}
		return hashmap;
	}
}

















