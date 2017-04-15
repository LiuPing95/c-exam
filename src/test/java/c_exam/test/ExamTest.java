package c_exam.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import c_exam.mapper.ExamMapper;
import c_exam.pojo.dao.ExamInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class ExamTest {

	@Autowired
	private ExamMapper mapper;
	
	@Test
	public void testAdd() {
		ExamInfo obj = new ExamInfo();
		obj.setExamId(100001);
		obj.setQuestionId(100001);
		mapper.addExam(obj);
	}
	
	@Test
	public void testGetById() {
		System.out.println(mapper.getExamInfoById(100001));
	}
	
	@Test
	public void testGet() {
		System.out.println(mapper.getExamInfos(0, 10));
	}
	
}
