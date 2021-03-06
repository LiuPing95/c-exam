package c_exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import c_exam.pojo.dao.RoleAccessInfo;

/**
 * 角色权限数据接口
 * 
 * @author LiuPing
 * @since 2017年3月18日
 */
public interface RoleAccessMapper {

	void addRoleAccess(@Param("obj") RoleAccessInfo obj);

	List<RoleAccessInfo> getRoleAccessInfo(@Param("id") Integer id);
	
	List<Integer> getPermissionIdByRoleId(@Param("roleId") int roleId);

	void del(@Param("roleId") int roleId, @Param("permissionId") int permissionId);

}