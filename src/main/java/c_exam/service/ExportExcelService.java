/**
 * 北京钉图互动科技 all right reserver
 */
package c_exam.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author LiuPing
 * @since 2017年4月16日
 */
@Service
public class ExportExcelService {

	private Logger log = LoggerFactory.getLogger(ExportExcelService.class);

	public static final String PATH = "static/assets/file/export/";

	public final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public final Integer SIZE = 100;

	private final Integer MAX_ROW = 50000;

	/**
	 * 插入数据
	 * 
	 * @param prefix 文件路径前缀
	 * @param name 模块名称
	 * @param date 时间：yyyyMMddHHmmss
	 * @param sheetName sheet名称
	 * @param task 任务对象：必须设置id
	 * @param data 数据
	 * @return
	 * @throws IOException
	 */
	public void addData(String prefix, String userName, String name, String date, String sheetName, String[] data)
			throws IOException {
		String df = prefix + PATH + userName + "_" + name + "_" + date + ".xlsx";
		InputStream in = new FileInputStream(df);
		XSSFWorkbook wb = new XSSFWorkbook(in);
		XSSFSheet sheet = wb.getSheet(sheetName);
		int rowNum = sheet.getLastRowNum() + 1;
		for (int i = 0; i < data.length; i++) {
			Row row = sheet.getRow(rowNum);
			if (row == null) {
				row = sheet.createRow(rowNum);
			}
			Cell cell = row.getCell(i);
			if (cell == null) {
				cell = row.createCell(i);
			}
			cell.setCellValue(data[i]);
		}
		OutputStream out = new FileOutputStream(df);
		wb.write(out);
		out.close();
		wb.close();
		in.close();
	}

	/**
	 * 插入excel表头
	 * 
	 * @param prefix 文件路径前缀
	 * @param name 模块名称
	 * @param date 时间：yyyyMMddHHmmss
	 * @param sheetName sheet名称
	 * @param task 任务对象：必须设置id
	 * @param data 数据
	 * @return
	 */
	public boolean addHead(String prefix, String userName, String name, String date, String sheetName, String[] data) {
		try {
			String df = prefix + PATH + userName + "_" + name + "_" + date + ".xlsx";
			InputStream in = new FileInputStream(df);
			XSSFWorkbook wb = new XSSFWorkbook(in);
			XSSFSheet sheet = wb.getSheet(sheetName);
			if (sheet.getLastRowNum() == 0) {
				for (int i = 0; i < data.length; i++) {
					Row row = sheet.getRow(0);
					if (row == null) {
						row = sheet.createRow(0);
					}
					Cell cell = row.getCell(i);
					if (cell == null) {
						cell = row.createCell(i);
					}
					cell.setCellValue(data[i]);
				}
				OutputStream out = new FileOutputStream(df);
				wb.write(out);
				out.close();
			}
			wb.close();
			in.close();
		} catch (Exception e) {
			log.error("插入表头失败", e);
			return false;
		}
		return true;
	}

	/**
	 * 获取sheetName
	 * 
	 * @param prefix 文件路径前缀
	 * @param name 模块名称
	 * @param date 时间：yyyyMMddHHmmss
	 * @return
	 * @throws IOException
	 */
	public String getSheetName(String prefix, String userName, String name, String date) throws IOException {
		int sheetNum = 1;
		String sheetName = "";
		String df = prefix + PATH + userName + "_" + name + "_" + date + ".xlsx";
		while (true) {
			InputStream in = new FileInputStream(df);
			XSSFWorkbook wb = new XSSFWorkbook(in);
			sheetName = "Sheet" + sheetNum;
			XSSFSheet sheet = wb.getSheet(sheetName);
			if (sheet == null) {
				sheet = wb.createSheet(sheetName);
			}
			if (sheet.getLastRowNum() < MAX_ROW) {
				break;
			}
			sheetNum++;
			wb.close();
			in.close();
		}
		return sheetName;
	}

	/**
	 * 复制excel
	 * 
	 * @param prefix 文件路径前缀
	 * @param name 模块名称
	 * @param date 时间：yyyyMMddHHmmss
	 * @return
	 */
	public boolean cpExcel(String prefix, String userName, String name, String date) {
		String location = PATH + userName + "_" + name + "_" + date + ".xlsx";
		String sf = prefix + PATH + "excel.xlsx";
		String df = prefix + location;
		return cp(sf, df);
	}

	/**
	 * 复制文件
	 * 
	 * @param s 源文件路径
	 * @param t 目标文件路径
	 */
	private boolean cp(String s, String t) {
		FileInputStream fi = null;
		FileOutputStream fo = null;
		FileChannel in = null;
		FileChannel out = null;
		try {
			String s_ = s;
			if (s.indexOf("%20") > 0) {
				s_ = s.replaceAll("%20", " ");
			}
			fi = new FileInputStream(new File(s_));
			fo = new FileOutputStream(new File(t));
			in = fi.getChannel();
			out = fo.getChannel();
			in.transferTo(0, in.size(), out);
			return true;
		} catch (IOException e) {
			log.error("复制文件失败", e);
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (fo != null) {
					fo.close();
				}
				if (in != null) {
					in.close();
				}
				if (fi != null) {
					fi.close();
				}
			} catch (IOException e) {
				log.error("释放资源失败", e);
			}
		}
		return false;
	}

}
