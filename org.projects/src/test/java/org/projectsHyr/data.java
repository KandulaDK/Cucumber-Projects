package org.projectsHyr;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class data {

	public static void main(String[] args) {
		readExcel();
		String a = "String";
		System.out.println(a.getClass().getSimpleName());

	}

	@DataProvider
	public static void readExcel() {
		Object[] obj = null;

		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\VegList.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("Vegetables");
		
			for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
				XSSFRow row = sheet.getRow(i);
				HashMap<String, String> keyValue = new HashMap<String, String>();
				Object[] tempo = new Object[row.getPhysicalNumberOfCells()];
				for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
					XSSFCell cell = row.getCell(j);
					String value = getCellValue(cell);
					tempo[j] = value;
					System.out.println(value);
					System.out.println(value.getClass().getSimpleName());
				}
				String product = (String) tempo[0];
				String qty = (String) tempo[1];
				keyValue.put(product, qty);
				obj[i-1] = keyValue;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String getCellValue(XSSFCell cell) {
		// TODO Auto-generated method stubpublic String getCellValue(XSSFCell cell) {
		switch (cell.getCellType()) {

		case NUMERIC:
			return String.valueOf(cell.getNumericCellValue());
		case STRING:
			return String.valueOf(cell.getStringCellValue());
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		default:
			return cell.getStringCellValue();
		}
	}
}
