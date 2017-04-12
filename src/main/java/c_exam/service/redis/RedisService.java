package c_exam.service.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author LiuPing
 * @param <V>
 * @param <K>
 * @since 2017年3月19日
 */
@Service
public class RedisService {

	@Autowired
	private StringRedisTemplate redisTemplate;
	
	@Autowired
	private RedisTemplate<String, Object> template;
	
	public void addObject() {
		template.boundHashOps("aa").put("aaa", "vsluie");
	}
	
}
