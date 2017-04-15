package c_exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import c_exam.pojo.dao.PermissionInfo;

/**
 * 权限接口
 * 
 * @author LiuPing
 * @since 2017年3月18日
 */
public interface PermissionMapper {

	void addPermission(@Param("obj") PermissionInfo obj);

	/**
	 * 查询权限信息
	 * @param rid 角色id
	 * @return
	 */
	List<PermissionInfo> getPermissionInfos(@Param("rid") Integer rid);
	
	/**
	 * TODO:暂未实现
	 */
	PermissionInfo getPermissionInfo(@Param("id") Integer id);

}