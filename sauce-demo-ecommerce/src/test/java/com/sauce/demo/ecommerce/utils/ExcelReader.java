package com.sauce.demo.ecommerce.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	private static XSSFWorkbook wb;
	private static XSSFSheet sheet;

	public static Object[][] getTableArray(String path, String sheetName) {
		InputStream ip = null;
		Object[][] tabArray;
		try {
			ip = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		int cellCount = sheet.getRow(sheet.getFirstRowNum()).getLastCellNum();
		tabArray = new Object[rowCount][cellCount];
		for (int i = 1; i <=rowCount; i++) {

			for (int j = 0; j < cellCount; j++) {
				tabArray[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return tabArray;
	}

}
