package c_exam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c_exam.mapper.UserMapper;
import c_exam.pojo.dto.UserDto;
import c_exam.service.UserService;

/**
 * @author LiuPing
 * @since 2017年4月16日
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;

	public UserDto userLogin() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
