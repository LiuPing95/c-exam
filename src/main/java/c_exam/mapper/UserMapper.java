package c_exam.mapper;

import org.apache.ibatis.annotations.Param;

import c_exam.bean.user.UserInfo;

/**
 * @author LiuPing
 * @since 2017年3月29日
 */
public interface UserMapper {

	void addUser(@Param("obj") UserInfo obj);
}
