package c_exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import c_exam.pojo.dao.UserInfo;

/**
 * @author LiuPing
 * @since 2017年3月29日
 */
public interface UserMapper {

	void addUser(@Param("obj") UserInfo obj);

	/**
	 * 分页查询数据，TODO：后面还要支持多条件分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	List<UserInfo> getUsers(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
	
	/**
	 * 根据userId精确查找用户
	 * 
	 * @param userId
	 * @return
	 */
	UserInfo getUserById(@Param("userId") Integer userId);
}
