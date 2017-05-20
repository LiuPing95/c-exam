package c_exam.service;

import java.util.List;

import c_exam.pojo.dao.UserInfo;
import c_exam.pojo.dto.UserDto;

public interface UserService {

	UserDto userLogin(UserInfo user);
	
	UserDto getUserById(int userId);

	List<UserDto> getUserByPage(int pageNum, int pageSize);

	void updateUser(UserInfo user);

	void add(UserInfo user);

	void updateCurUser(UserInfo user);

	void del(Integer id);

	List<UserDto> getStudents();
	
}
