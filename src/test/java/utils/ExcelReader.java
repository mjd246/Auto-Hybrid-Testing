package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	FileInputStream file;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	XSSFWorkbook workbook;
	String path;

	public int totalRowsXl(String path, String sheetName) throws IOException

	{
		file = new FileInputStream(path);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		int rowcount = sheet.getLastRowNum();
		workbook.close();
		file.close();
		return rowcount;

	}

	public int totalColXl(String path, String sheetName, int rowv) throws IOException

	{
		file = new FileInputStream(path);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowv);
		int cellcount = row.getLastCellNum();
		workbook.close();
		file.close();
		return cellcount;
	}

	public String getCellData(String path, String sheetName, int rownum, int colnum) throws IOException {

		file = new FileInputStream(path);
		workbook = new XSSFWorkbook(file);

		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);

		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			data = formatter.formatCellValue(cell); // Returns the formatted value of a cell as a String regardless of
													// the cell type.
		} catch (Exception e) {
			data = "";
		}
		workbook.close();
		file.close();
		return data;
	}

	public String[][] getAllData(String path, String sheetName) throws IOException {
		try {
			file = new FileInputStream(path);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			workbook = new XSSFWorkbook(file);
		} catch (IOException e) {

			e.printStackTrace();
		}
		sheet = workbook.getSheet(sheetName);
		int rowcount = sheet.getLastRowNum();
		row = sheet.getRow(0);
		int cellcount = row.getLastCellNum();

		String value[][] = new String[rowcount][cellcount];

		for (int r = 1; r <= rowcount; r++)

		{
			for (int c = 0; c < cellcount; c++) {
				value[r - 1][c] = getCellData(path, sheetName, r, c).toString();
			}
		}

		workbook.close();
		file.close();
		return value;

	}

	/*
	 * public static void main(String[] args) throws IOException {
	 * 
	 * String filep = System.getProperty("user.dir") + "\\testdata\\ecommerce.xlsx";
	 * // ExcelReader exl = new ExcelReader(); // //
	 * System.out.println(exl.totalRowsXl("Sheet1")); //
	 * System.out.println(exl.totalColXl("Sheet1", 1)); // int totr =
	 * exl.totalRowsXl(filep, "Sheet1"); int totc = exl.totalColXl(filep,"Sheet1",
	 * 1);
	 * 
	 * String value[][] = exl.getAllData(filep,"Sheet1");
	 * 
	 * for (int r = 1; r <= totr; r++)
	 * 
	 * { for (int c = 0; c < totc; c++) { //value[r - 1][c] =
	 * exl.getCellData("Sheet1", r, c).toString();
	 * 
	 * System.out.print(value[r - 1][c] + " "); }
	 * 
	 * System.out.println(); }
	 * 
	 * }
	 */

}
