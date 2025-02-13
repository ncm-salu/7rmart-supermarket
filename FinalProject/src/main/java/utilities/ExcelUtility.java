package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constants;

public class ExcelUtility {
	public static XSSFWorkbook w;
	public static XSSFSheet s;
	public static FileInputStream f;

	public static String readStringData(int row, int col, String sheet) throws IOException {
		String filepath = Constants.TESTDATAFILE;
		f = new FileInputStream(filepath);
		w = new XSSFWorkbook(f);
		s = w.getSheet(sheet);
		XSSFRow r = s.getRow(row);
		XSSFCell c = r.getCell(col);
		return c.getStringCellValue();

	}

	public static String readIntegerData(int row, int col, String sheet) throws IOException {
		String filepath = Constants.TESTDATAFILE;
		f = new FileInputStream(filepath);
		w = new XSSFWorkbook(f);
		s = w.getSheet(sheet);
		XSSFRow r = s.getRow(row);
		XSSFCell c = r.getCell(col);
		int value = (int) c.getNumericCellValue();
		return String.valueOf(value);

	}
}
