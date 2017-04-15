package c_exam.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import c_exam.mapper.ExamMapper;
import c_exam.mapper.ExamSerialMapper;
import c_exam.pojo.dao.ExamInfo;
import c_exam.pojo.dao.ExamSerialInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class ExamSerialTest {

	@Autowired
	private ExamSerialMapper mapper;
	
	@Test
	public void testAdd() {
		ExamSerialInfo obj = new ExamSerialInfo();
		obj.setForDesc("其中考试");
		mapper.addExamSerial(obj);
		ExamSerialInfo obj2 = new ExamSerialInfo();
		obj2.setForDesc("期末考试");
		mapper.addExamSerial(obj2);

	}
	
	@Test
	public void testGetById() {
		System.out.println(mapper.getExamSerialInfoById(100001));
	}
	
	@Test
	public void testGet() {
		System.out.println(mapper.getExamSerialInfo(0, 3));
	}
	
}
