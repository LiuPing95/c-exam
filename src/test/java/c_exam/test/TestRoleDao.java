package c_exam.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import c_exam.bean.role.RoleInfo;
import c_exam.mapper.RoleMapper;

/**
 * @author LiuPing
 * @since 2017年3月29日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestRoleDao {
	
	@Autowired
	private RoleMapper mapper;

	@Test
	public void testAdd() {
		RoleInfo role =  new RoleInfo();
		role.setName("教师");
		role.setForDesc("");
		mapper.addRole(role);
	}
}
