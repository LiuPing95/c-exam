//package c_exam.util;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.OutputStream;
//
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import com.softlib.common.schema.Field;
//import com.softlib.common.schema.RecordSet;
//import com.softlib.platform.common.constants.DataType;
//
//import jxl.CellType;
//import jxl.Sheet;
//import jxl.Cell;
//import jxl.Workbook;
//import jxl.read.biff.BiffException;
//import jxl.write.Label;
//import jxl.write.Number;
//import jxl.write.WritableCell;
//import jxl.write.WritableSheet;
//import jxl.write.WritableWorkbook;
//import jxl.write.WriteException;
//import jxl.write.biff.RowsExceededException;
//
///**
// * excel帮助类 excel中，workbook就是一个文件，worksheet就是里面的表，表可以定义名字
// * 所以先定义workbook，在从workbook中获取worksheet（sheet）
// */
//public class GenExcelUtil {
//
//	/**
//	 * 导出excel数据
//	 * 
//	 * @param recordSet：导出的所有记录
//	 * @param os：导出的目标文件流
//	 * @param sheetName：
//	 * @return 返回一个有数据的表
//	 * @throws Exception
//	 */
//	public static WritableWorkbook writeExcel(RecordSet recordSet, OutputStream os, String sheetName) throws Exception {
//		WritableWorkbook wwb = null;
//		try {
//			// 生成excel文件
//			wwb = Workbook.createWorkbook(os);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		if (wwb != null) {
//			// 生成名字为sheetName的第一页工作表
//			WritableSheet ws = wwb.createSheet(sheetName, 0);
//			// 如果没有数据则返回
//			if (recordSet == null || recordSet.getRecords() == null || recordSet.getRecords().size() < 1) {
//				return wwb;
//			}
//			// 循环取出数据集中的数据
//			for (int i = 0; i <= recordSet.getRecords().size(); i++) {
//				// 获取到列数
//				int size = recordSet.getRecord(0).getFields().size();
//				int column = 0;
//				for (int j = 0; j < size; j++) { // 循环列
//					String content = "";
//					Label labelC = null;
//
//					// 判断这个属性是不是需要显示？
//					if (i == 0) {
//						if (recordSet.getRecord(i).getField(j).getVisible() == 1) {
//							content = recordSet.getRecord(i).getField(j).getDescName();
//							labelC = new Label(column, i, content);
//							column++;
//						}
//					} else {
//						if (recordSet.getRecord(i - 1).getField(j).getVisible() == 1) {
//							content = recordSet.getRecord(i - 1).getField(j).getVaD();
//							labelC = new Label(column, i, content);
//							column++;
//						}
//					}
//					// 把这个值添加到表格中
//					try {
//						ws.addCell(labelC);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		}
//		return wwb;
//	}
//
//	/**
//	 * 根据文件路径和后缀获取工作表
//	 * 
//	 * @param filePath
//	 * @param fileExt
//	 * @return
//	 */
//	public static Object getWorkBook(String filePath, String fileExt) {
//		Object objWorkBook = null;
//		// xlsx后面的x代表扩展，如果是新版本的则要生成扩展的工作簿
//		if (fileExt.equalsIgnoreCase("xlsx")) {
//			objWorkBook = GenExcelUtil.createXSSWorkBook(filePath);
//		} else {
//			objWorkBook = GenExcelUtil.createWorkBook(filePath);
//		}
//		return objWorkBook;
//	}
//
//	/**
//	 * 根据文件获取工作簿
//	 * 
//	 * @param filePath
//	 * @return
//	 */
//	public static Object getWorkBook(String filePath) {
//		String fileExt = "xls";
//		// 如果文件路径带有后缀名就取这个文件的后缀
//		if (filePath.lastIndexOf(".") > 0)
//			fileExt = filePath.substring(filePath.lastIndexOf(".") + 1);
//		// 调用上面带后缀的方法，如果是这样的话那么上面的方法可以设计成私有的？
//		return getWorkBook(filePath, fileExt);
//	}
//
//	/**
//	 * 获取工作表
//	 * 
//	 * @param obj
//	 * @param sheetIndex
//	 * @return
//	 */
//	public static Object getWorkBookSheet(Object obj, int sheetIndex) {
//		// 获取默认的第一个表
//		if (obj instanceof XSSFWorkbook)
//			return getWorkBookSheet((XSSFWorkbook) obj, sheetIndex);
//		else
//			return getWorkBookSheet((Workbook) obj, sheetIndex);
//	}
//
//	private static XSSFSheet getWorkBookSheet(XSSFWorkbook xsswb, int sheetIndex) {
//		return xsswb.getSheetAt(0);
//	}
//
//	private static Sheet getWorkBookSheet(Workbook wb, int sheetIndex) {
//		return wb.getSheet(0);
//	}
//
//	/**
//	 * 根据行和列获取表格中的数据，坐标从0开始
//	 * 
//	 * @param sheet：工作表
//	 * @param icol：列
//	 * @param irow：行
//	 * @return
//	 */
//	public static String getCellText(Object sheet, int icol, int irow) {
//		if (sheet instanceof XSSFSheet) {
//			return getCellText((XSSFSheet) sheet, icol, irow);
//		} else if (sheet instanceof Sheet) {
//			return getCellText((Sheet) sheet, icol, irow);
//		} else {
//			return "";
//		}
//	}
//
//	public static void setCellText(Object sheet, int icol, int irow, Field fld) {
//		if (sheet instanceof XSSFSheet) {
//			setCellText((XSSFSheet) sheet, icol, irow, fld);
//		} else if (sheet instanceof Sheet) {
//			setCellText((Sheet) sheet, icol, irow, fld);
//		}
//	}
//
//	public static String getCellText(XSSFSheet sheet, int icol, int irow) {
//		String strRtn = "";
//		XSSFRow row = sheet.getRow(irow);
//		int lastRowNum = sheet.getLastRowNum();
//
//		if (row == null) {
//
//			sheet.createRow(irow);
//			row = sheet.getRow(irow);
//		}
//
//		if (row != null) {
//			XSSFCell cell = row.getCell(icol);
//			if (cell == null) {
//				cell = row.createCell(icol);
//			}
//
//			if (cell != null) {
//				if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
//					strRtn = cell.getStringCellValue();
//				else if (cell.getCellType() == XSSFCell.CELL_TYPE_FORMULA)
//					strRtn = cell.getRawValue();
//				else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
//					strRtn = NumericUtil.getFormatDigitValue(4, cell.getNumericCellValue());
//				else
//					strRtn = cell.getStringCellValue();
//			}
//		} else {
//			// sheet.setRandomAccessWindowSize();
//			// XSSFCell cell=sheet.getRow(irow).getCell(icol);
//			// strRtn=cell.getStringCellValue();
//		}
//		return strRtn.trim();
//	}
//
//	public static void setCellText(XSSFSheet sheet, int icol, int irow, Field fld) {
//		if (sheet.getLastRowNum() < irow || sheet.getRow(irow) == null)
//			sheet.createRow(irow);
//		if (sheet.getRow(irow).getLastCellNum() < icol)
//			sheet.getRow(irow).createCell(icol);
//		if (sheet.getRow(irow).getCell(icol) == null)
//			sheet.getRow(irow).createCell(icol);
//
//		XSSFCell cell = sheet.getRow(irow).getCell(icol);
//		cell.setCellValue(fld.getVal().toString());
//	}
//
//	public static String getCellText(Sheet sheet, int icol, int irow) {
//		String strRtn = "";
//		if (irow < sheet.getRows() && icol < sheet.getColumns()) {
//			Cell cell = sheet.getCell(icol, irow);
//			if (cell != null) {
//				CellType celltype = cell.getType();
//				if (celltype == CellType.DATE) {
//					strRtn = cell.getContents();
//					strRtn = DateUtil.dateToString(DateUtil.shortStringToDate(strRtn));
//				} else if (celltype == CellType.NUMBER) {
//					strRtn = sheet.getCell(icol, irow).getContents();
//				} else {
//					strRtn = sheet.getCell(icol, irow).getContents();
//				}
//
//			}
//		}
//		return strRtn.trim();
//	}
//
//	public static void setCellText(WritableSheet sheet, int icol, int irow, Field fld) {
//		try {
//			sheet.addCell(getValueComponent(icol, irow, fld));
//		} catch (RowsExceededException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (WriteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	private static WritableCell getValueComponent(int col, int row, Field fld) {
//		WritableCell obj = null;
//		if (fld.getVal() != null && fld.getVal().toString().length() > 0) {
//			if (fld.getDataType() == DataType._INTEGER || fld.getDataType() == DataType._NUMERIC)
//				obj = new Number(col, row, Float.valueOf(fld.getVal().toString()));
//			else if (fld.getDataType() == DataType._DATE || fld.getDataType() == DataType._DATETIME
//					|| fld.getDataType() == DataType._TIMESTAMP)
//				obj = new Label(col, row, fld.getVaD());
//			// obj=new DateTime(col, row,(Date)(fld.getVal()));
//			else if (fld.getDataType() == DataType._TIME)
//				// obj=new DateTime(col, row, (Date)(fld.getVal()));
//				obj = new Label(col, row, fld.getVaD());
//			else
//				obj = new Label(col, row, fld.getVaD());
//		} else {
//			obj = new Label(col, row, fld.getVaD());
//		}
//		return obj;
//
//	}
//
//	/**
//	 * 根据文件路径生成工作表：xlsx
//	 * 
//	 * @param filePath
//	 * @return
//	 */
//	public static XSSFWorkbook createXSSWorkBook(String filePath) {
//		FileInputStream is = null;
//		XSSFWorkbook result = null;
//		try {
//			is = new FileInputStream(filePath);
//			result = new XSSFWorkbook(is);
//			is.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return result;
//	}
//
//	/**
//	 * 根据文件路径生成工作表
//	 * 
//	 * @param filePath
//	 * @return
//	 */
//	public static Workbook createWorkBook(String filePath) {
//		FileInputStream is = null;
//		Workbook result = null;
//		try {
//			is = new FileInputStream(filePath);
//			try {
//				result = Workbook.getWorkbook(is);
//			} catch (BiffException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			is.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return result;
//	}
//}
