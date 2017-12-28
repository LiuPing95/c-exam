package c_exam.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil1 {

	// "C:\\Users\\Apple\\Desktop\\bank_personinfo.xls"
	
	public static void main(String[] args) throws IOException {
		
		//Workbook=>xls
		//XSSFWorkbook =>xlsx path =
		String path = "C:\\Users\\Apple\\Desktop\\11.xls";
//		Workbook wwb = new 
		Workbook wb = new XSSFWorkbook(path); //
		Sheet sheet = wb.createSheet("mySheet");
		for (int i = 0; i < 5; i ++) {
			Row row = sheet.createRow(i);
			for (int j = 0; j < 5; j ++) {
				Cell cell = row.createCell(j);
				cell.setCellValue("apple");
			}
		}
		OutputStream os = new FileOutputStream(path);
		wb.write(os);
		os.close();
		wb.close();
	}
}
