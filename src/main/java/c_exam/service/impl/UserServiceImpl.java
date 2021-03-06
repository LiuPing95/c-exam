package c_exam.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c_exam.mapper.ClassMapper;
import c_exam.mapper.DeptMapper;
import c_exam.mapper.RoleMapper;
import c_exam.mapper.UserMapper;
import c_exam.pojo.dao.UserInfo;
import c_exam.pojo.dto.UserDto;
import c_exam.service.UserService;

/**
 * 用户
 * 
 * @author LiuPing
 * @since 2017年4月16日
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private ClassMapper classMapper;
	
	@Autowired
	private DeptMapper deptMapper;
	
	@Autowired
	private RoleMapper roleMapper;

	public UserDto userLogin(UserInfo user) {
		UserInfo info = userMapper.userLogin(user);
		if (info == null) {
			return null;
		}
		UserDto dto = new UserDto();
		BeanUtils.copyProperties(info, dto);
		dto.setDeptName(deptMapper.getDeptById(dto.getDeptId()).getName());
		dto.setRoleName(roleMapper.getRoleInfoById(dto.getRoleId()).getName());
		dto.setClassName(classMapper.getClassInfoById(dto.getClassId()).getName());
		return dto;
	}

	public UserDto getUserById(int userId) {
		UserInfo user = userMapper.getUserById(userId);
		UserDto obj = new UserDto();
		BeanUtils.copyProperties(user, obj);
		obj.setDeptName(deptMapper.getDeptById(obj.getDeptId()).getName());
		obj.setRoleName(roleMapper.getRoleInfoById(obj.getRoleId()).getName());
		obj.setClassName(classMapper.getClassInfoById(obj.getClassId()).getName());
		return obj;
	}

	public List<UserDto> getUserByPage(int pageNum, int pageSize) {
		return userMapper.getUsers((pageNum-1) * pageSize, pageNum * pageSize);
	}

	public void updateUser(UserInfo user) {
		userMapper.updateCurUser(user);
	}

	public void add(UserInfo user) {
		userMapper.addUser(user);
	}

	public void updateCurUser(UserInfo user) {
		userMapper.updateCurUser(user);
	}

	public void del(Integer id) {
		userMapper.del(id);
	}

	public List<UserDto> getStudents() {
		return userMapper.getStudents();
	}

}
