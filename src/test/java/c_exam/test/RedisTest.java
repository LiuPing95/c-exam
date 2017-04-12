package c_exam.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import c_exam.pojo.dao.ClassInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class RedisTest {

	@Autowired
	private RedisTemplate<String, ClassInfo> redisTemplate;
	
	@Test
	public void testAdd() {
		ClassInfo o = new ClassInfo();
//		redisTemplate.boundHashOps("key1").put("key3", o);
		redisTemplate.boundListOps("list").leftPush(o);
	}
	
	@Test
	public void testGet() {
		ClassInfo c = redisTemplate.boundListOps("list").leftPop();
		redisTemplate.boundListOps("").range(0, 1);
		DataType type = redisTemplate.boundListOps("list").getType();
		System.out.println(type.getDeclaringClass());
		System.out.println(c);
	}
	
	@Test
	public void testDel() {
		redisTemplate.delete("list");
	}
}
