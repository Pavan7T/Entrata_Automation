package com.entrata.resources;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadExcelUtils {

	public static Object[][] getExcelData(String excelPath, String sheetName) throws IOException {
		FileInputStream fis = new FileInputStream(new File(excelPath));
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);

		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

		Object[][] data = new Object[rowCount - 1][colCount]; // Exclude header row

		for (int i = 1; i < rowCount; i++) { // Start from 1 to skip header
			Row row = sheet.getRow(i);
			for (int j = 0; j < colCount; j++) {
				Cell cell = row.getCell(j);
				if (cell != null) {
					data[i - 1][j] = cell.toString();
				}
			}
		}
		workbook.close();
		fis.close();
		return data;
	}
}
