package c_exam.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import c_exam.mapper.QuestionMapper;
import c_exam.pojo.dao.QuestionInfo;
import c_exam.pojo.dao.QuestionType;
import c_exam.util.ExcelUtil;

/**
 * @author LiuPing
 * @since 2017年4月18日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class ExcelTest {
	
	@Autowired
	private QuestionMapper mapper;
	
	@Test
	public void testAdd() throws IOException {
		String str = getData();
		String[] strs = str.split("\\d{1,2}\\.");
		for (String string : strs) {
			QuestionInfo info = new QuestionInfo();
//			System.out.println(string);
			String[] arr = string.split("[A-D]\\.");
//			System.out.println(arr.length);
//			for (String string2 : arr) {
//				System.out.println(string2);
//				System.err.println("================");
//			}
			if (arr.length != 5) {
				continue;
			}
			info.setQuestionType(QuestionType.CHOOSE.getValue());
			info.setContent(arr[0]);
			info.setItemA(arr[1]);
			info.setItemB(arr[2]);
			info.setItemC(arr[3]);
			String[] aa = arr[4].split("分析:");
			info.setItemD(aa[0]);
			info.setForComment(aa[1]);
			info.setAnswer("");
			mapper.addQuestion(info);
		}
	}
	
	public static String getData() throws IOException {
		FileInputStream fis = new FileInputStream(new File("C:\\Users\\Apple\\Desktop\\44.txt"));
		StringBuffer sb = new StringBuffer("");
		byte[] b = new byte[1024];
		while (fis.read(b , 0, b.length) != -1) {
			String s = new String(b, "utf-8");
			sb.append(s);
		}
		// 最后关闭流
		fis.close();
		return sb.toString();
	}
	
	@Test
	public void test() throws InvalidFormatException, IOException {
		FileInputStream fis = new FileInputStream(new File("C:\\Users\\Apple\\Desktop\\template.xlsx"));
		String[][] data = ExcelUtil.getData(fis, 1);
		for (String[] arr : data) {
			QuestionInfo info = new QuestionInfo();
			info.setQuestionType(arr[1]);
			info.setContent(arr[2]);
			info.setForComment(arr[3]);
			info.setItemA(arr[4].trim());
			info.setItemB(arr[5].trim());
			info.setItemC(arr[6].trim());
			info.setItemD(arr[7].trim());
			info.setAnswer(arr[8]);
			mapper.addQuestion(info);
		}
	}
}