package c_exam.mapper;

import org.apache.ibatis.annotations.Param;

import c_exam.pojo.dao.UserInfo;

/**
 * @author LiuPing
 * @since 2017年3月29日
 */
public interface UserMapper {

	void addUser(@Param("obj") UserInfo obj);
}
