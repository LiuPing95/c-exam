package c_exam.service;

import java.util.List;

import c_exam.pojo.dto.UserDto;

public interface UserService {

	UserDto userLogin();
	
	UserDto getUserById(int userId);

	List<UserDto> getUserByPage(int pageNum, int pageSize);

	void updateUser(UserDto user);
	
}
