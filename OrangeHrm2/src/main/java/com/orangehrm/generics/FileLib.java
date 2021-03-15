package com.orangehrm.generics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * Note: This is the generic class for data drivern testing
 * @author Asha N
 *
 */
public class FileLib {
	/**
	 * Note: Reading the data from the property file
	 * @param key
	 * @return String value
	 * @throws IOException
	 */
	public String getPropertyValue(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/data/input.property");
		Properties p=new Properties();
		p.load(fis);
		String value=p.getProperty(key);
		return value;	
	}
	/**
	 * Note: Reading data from ExcelSheet
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return String Value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @throws InvalidFormatException 
	 */
	public String getExcelValue(String sheetName,int row, int cell) throws EncryptedDocumentException, IOException, InvalidFormatException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/data/excel_input.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String value=wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		return value;	
	}
	
	/**
	 * Note: Write data to the Excel file
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @throws InvalidFormatException 
	 */
	public void setExcelValue(String sheetName,int row, int cell) throws EncryptedDocumentException, IOException, InvalidFormatException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/data/excel_input.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		FileOutputStream fos=new FileOutputStream("./data/excel_input.xlsx");
		wb.write(fos);
		wb.close();
	}
}
