package c_exam.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import c_exam.mapper.ClassMapper;
import c_exam.pojo.dao.ClassInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class ClassTest {

	@Autowired
	private ClassMapper mapper;
	
	@Test
	public void testAdd() {
		ClassInfo obj = new ClassInfo();
		obj.setName("物联网工程");
		obj.setDeptId(100001);
		mapper.addClass(obj );
	}
	
	@Test
	public void testGetById() {
		ClassInfo classes = mapper.getClassInfoById(100001);
		System.out.println(classes);
	}
	
	@Test
	public void testGetClass() {
		List<ClassInfo> classes = mapper.getClassInfo(0, 10);
		System.out.println(classes);
	}
}
