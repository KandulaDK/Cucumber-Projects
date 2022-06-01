package org.projectsHyr;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWorkBook {
	public static void main(String[] args) throws Exception {
		try {
			File f = new File("C:\\Users\\DinnuBunny\\Desktop\\Book11.xlsx");
			System.out.println(f.exists());
			FileInputStream fis = new FileInputStream(f);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			int rowCount = sheet.getPhysicalNumberOfRows();
			
			for(int i=0;i<rowCount;i++) {
				XSSFRow row = sheet.getRow(i);
				
				int cellCount = row.getPhysicalNumberOfCells();
				for(int j=0;j<cellCount;j++) {
					XSSFCell cell = row.getCell(j);
					String cellValue = getCellValue(cell);
					System.out.print("| " + cellValue);
				}
				System.out.println("|");
			}
			
			workbook.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private static String getCellValue(XSSFCell cell) {
		// TODO Auto-generated method stubpublic String getCellValue(XSSFCell cell) {
		switch(cell.getCellType()) {
		
		case NUMERIC:
			return String.valueOf(cell.getNumericCellValue());
//			return CellType.NUMERIC;
		case STRING:
			return String.valueOf(cell.getStringCellValue());
//			return CellType.STRING;
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
//			return CellType.BOOLEAN;
		default:
			return cell.getStringCellValue();
		}	
	}
}

