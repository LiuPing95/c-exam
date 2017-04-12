package c_exam.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import c_exam.mapper.DeptMapper;
import c_exam.pojo.dao.DeptInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class DeptTest {

	@Autowired
	private DeptMapper mapper;
	
	@Test
	public void testAdd() {
		DeptInfo obj = new DeptInfo();
		obj.setName("计算机科学与技术学院");
		mapper.addDept(obj);
	}
}
