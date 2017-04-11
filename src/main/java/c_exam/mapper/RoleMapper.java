package c_exam.mapper;

import org.apache.ibatis.annotations.Param;

import c_exam.pojo.dao.RoleInfo;

/**
 * @author LiuPing
 * @since 2017年3月29日
 */
public interface RoleMapper {

	void addRole(@Param("obj") RoleInfo obj);
}
