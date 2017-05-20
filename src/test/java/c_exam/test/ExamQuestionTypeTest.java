package c_exam.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import c_exam.mapper.ExamQuestionTypeMapper;
import c_exam.pojo.dao.ExamQuestionType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class ExamQuestionTypeTest {

	@Autowired
	private ExamQuestionTypeMapper mapper;
	
	@Test
	public void testAdd() {
		ExamQuestionType obj = new ExamQuestionType();
		obj.setExamId(100001);
		obj.setSum(10);
		obj.setType("选择题");
		mapper.addExamQuestionType(obj);
	}
	
	@Test
	public void testGetById() {
		System.out.println(mapper.getExamQuestionTypeById(100001));
	}
	
	@Test
	public void testGetByExamId() {
		System.out.println(mapper.getExamQuestionTypeByExamId(100001));
	}
	
	@Test
	public void testGet() {
		System.out.println(mapper.getExamQuestionTypes(0, 10));
	}
}
