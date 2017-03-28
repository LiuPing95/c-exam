package c_exam.test.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author LiuPing
 * @since 2017年3月18日
 */
public class ParseUtil {
	
	public static void main(String[] args) throws Exception {
		parse("C:\\Users\\Apple\\Desktop\\11.txt", "C:\\Users\\Apple\\Desktop\\6.txt");
	}

	public static void parse(String srcPath, String destPath) throws Exception {
		
		File srcFile = new File(srcPath);
		File destFile = new File(destPath);
		InputStream is = new FileInputStream(srcFile);
		OutputStream os = new FileOutputStream(destFile);
		byte[] b = new byte[20];
		while(is.read(b) != -1){
			String s1 = new String(b,"utf-8");
//			os.write(b);
			System.out.println(s1);
		}
	}
}