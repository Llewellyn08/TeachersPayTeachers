package com.tpt.dataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.tpt.utility.NewExcelLibraryTpT;

public class DataProvidersTpT {
	
	NewExcelLibraryTpT obj = new NewExcelLibraryTpT();
	
	@DataProvider(name = "Credentials")
	public Object[][] Credentials() throws IOException{
		FileInputStream fis = new FileInputStream(dataPath + "TestDataTpT.xlsx");
		Object[][] data = getAllData(fis, "Credentials");
		return data;
	}
	
	
	DataFormatter formatter = new DataFormatter();
	String dataPath = "src\\test\\resources\\TestData\\";
	
	public Object[][] getAllData(FileInputStream fis, String sheetName) throws IOException {
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		// XSSFSheet sheet = wb.getSheetAt(0);
		XSSFSheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		Object data[][] = new Object[rowCount - 1][colCount];
		for (int i = 0; i < rowCount - 1; i++) {
			row = sheet.getRow(i + 1);
			for (int j = 0; j < colCount; j++) {
				XSSFCell cell = row.getCell(j);
				data[i][j] = formatter.formatCellValue(cell);
			}
		}
		return data;
	}

}
