package c_exam.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import c_exam.mapper.QuestionMapper;
import c_exam.pojo.dao.QuestionInfo;
import c_exam.pojo.dao.QuestionType;

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
		QuestionInfo obj = new QuestionInfo();
		obj.setContent("content");
		obj.setQuestionType(QuestionType.CHOOSE.getValue());
		obj.setForComment("forComment");
		obj.setAnswer("answer");
		obj.setItemA("A");
		obj.setItemB("B");
		obj.setItemC("C");
		obj.setItemD("D");
		mapper.addQuestion(obj);
	}
	
	@Test
	public void testGetById() {
//		List<QuestionInfo> info = mapper.getQuestionByPage(0, 10);
//		System.out.println(info);
	}
	
	@Test
	public void testGetByIds() {
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(100001);
		mapper.getQuestionByIds(ids );
	}
}
