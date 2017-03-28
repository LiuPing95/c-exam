package c_exam.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import c_exam.bean.question.Question;
import c_exam.mapper.QuestionMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestQuestionDao {

	@Autowired
	private QuestionMapper mapper;
	
	/**
	 * 测试单个添加：添加的时候必须每个字段都有值
	 */
	@Test
	public void testAdd() {
		Question obj = new Question();
		obj.setContent("content");
		obj.setQuestionType("questionType");
		obj.setForComment("forComment");
		obj.setAnswer("answer");
		obj.setItemA("A");
		obj.setItemB("B");
		obj.setItemC("C");
		obj.setItemD("D");
		mapper.addObj(obj);
	}
}
