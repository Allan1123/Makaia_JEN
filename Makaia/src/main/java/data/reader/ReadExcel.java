package data.reader;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {
	@Test
	public String[][] readExcel(String sheetName) throws IOException {
		XSSFWorkbook wbook=new XSSFWorkbook("./data/"+sheetName+".xlsx");
		XSSFSheet sheet = wbook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		System.out.println(rowCount);
		XSSFRow headerRow = sheet.getRow(0);
		int lastCellNum = headerRow.getLastCellNum();
		System.out.println(lastCellNum);
		String[][] data= new String[rowCount][lastCellNum];
		for(int i=1;i<=rowCount;i++) {
			XSSFRow row = sheet.getRow(i);
			for(int j=0;j<lastCellNum;j++) {
				XSSFCell cell = row.getCell(j);
				String value = cell.getStringCellValue();
				System.out.println(value);
				data[i-1][j]=value;
			}
		}
		wbook.close();
		return data;

	}

}
