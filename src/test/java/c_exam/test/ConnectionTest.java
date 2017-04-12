package c_exam.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class ConnectionTest {

	// 必须要引用javax中的DataSource
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	@Autowired
	private RedisTemplate<String, Object> template;
	
	@Test
	public void testRedisConnection() {
		RedisConnection con = redisTemplate.getConnectionFactory().getConnection();
		RedisConnection con1 = template.getConnectionFactory().getConnection();
		assertNotNull(con);
		assertNotNull(con1);
	}

	@Test
	public void testConnection() {
		Connection con = null;
		try {
			con = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		assertNotNull(con);
	}
	
	@Test
	public void test() {
		Connection con = sqlSessionFactory.openSession().getConnection();
		assertNotNull(con);
	}
	
}
