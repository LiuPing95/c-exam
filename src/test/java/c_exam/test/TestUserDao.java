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
		user.setAddr("地球");
		user.setCollege("衡阳师范学院");
		user.setBirthday("1995-01-27");
		user.setClassId(100001);
		user.setDeptId(100001);
		user.setGender("男");
		user.setIdCard("430581199501276010");
		user.setPwd("a");
		user.setImg("");
		user.setName("apple");
		user.setPhone("15675974359");
		user.setSign("时光静好，与君语；细水流年，与君同。");
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

