package c_exam.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import c_exam.mapper.UserMapper;
import c_exam.pojo.dao.UserInfo;

/**
 * @author LiuPing
 * @since 2017年3月29日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestUserDao {
	
	@Autowired
	private UserMapper mapper;

	@Test
	public void testAdd() {
		UserInfo user = new UserInfo();
		user.setRoleId(100001);
		user.setAddr("addr");
		user.setBirthday("birthday");
		user.setClassId(100001);
		user.setDeptId(100001);
		user.setGender("男");
		user.setIdCard("idCard");
		user.setPwd("pwd");
		user.setImg("img");
		user.setName("name");
		user.setPhone("phone");
		user.setSign("sign");
		mapper.addUser(user);
	}
	
	@Test
	public void testGetById(){
		System.out.println(mapper.getUserById(100001));
	}
	
	@Test
	public void testGet(){
		System.out.println(mapper.getUsers(1-1, 1*10));
	}
}

