package c_exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import c_exam.pojo.dao.RoleInfo;

/**
 * 角色接口
 * 
 * @author LiuPing
 * @since 2017年3月29日
 */
public interface RoleMapper {

	void addRole(@Param("obj") RoleInfo obj);
	
	RoleInfo getRoleInfoById(@Param("id") Integer id);
	
	List<RoleInfo> getRoleByPage(@Param("start") Integer start, @Param("end") Integer end);

	List<RoleInfo> getRoles();
}
