package org.projectsHyr;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;

import javax.sound.midi.SysexMessage;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.io.Files;

public class DataDrive {

//	static XMLOperation xml = new XMLOperation();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Object[][] data = null;
		ArrayList<HashMap<String, String>> finalTestSet = new ArrayList<HashMap<String, String>>();

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\Book11.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet worksheet = workbook.getSheet("Book1");
		data = new Object[worksheet.getLastRowNum()][1];

		Row headerRow = worksheet.getRow(0);
//		System.out.println(worksheet.getPhysicalNumberOfRows());
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			HashMap<String, String> dataHash = new HashMap<String, String>();
			Row row = worksheet.getRow(i);

			for (int j = headerRow.getFirstCellNum(); j < headerRow.getPhysicalNumberOfCells(); j++) {
				dataHash.put(getCellValue((XSSFCell) headerRow.getCell(j)), getCellValue((XSSFCell) row.getCell(j)));

			}
			data[i - 1][0] = dataHash;
		}

		System.out.println(data);

		for (int i = 0; i < data.length; i++) {
			@SuppressWarnings("unchecked")
			HashMap<String, String> testData = (HashMap<String, String>) data[i][0];
			if (testData.get("Status").equalsIgnoreCase("True"))
				finalTestSet.add(testData);
		}

		Object[][] finaldataset = new Object[finalTestSet.size()][1];
		for (int i = 0; i < finalTestSet.size(); i++) {
			HashMap<String, String> testData = finalTestSet.get(i);
			finaldataset[i][0] = testData;
		}
		System.out.println(finaldataset);

//		ArrayList<HashMap<String, String>> test = new ArrayList<HashMap<String, String>>();
//		HashMap<String, String> n = new HashMap<String, String>();
//		n.put("a", "a");
//		n.put("b", "b");
//		test.add(n);
//		String strArr[] = new String[m.size()];
//		int i = 0;
//		for (HashMap<String, String> hash : test) {
//		    for (String current : hash.keySet()) {
//		        strArr[i] = current;
//		        System.out.println(current);
//		        i++;
//		    }
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
