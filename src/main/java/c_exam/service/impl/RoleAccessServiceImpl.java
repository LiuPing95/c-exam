package c_exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c_exam.mapper.RoleAccessMapper;
import c_exam.pojo.dao.RoleAccessInfo;
import c_exam.service.RoleAccessService;

/**
 * 权限访问控制
 * 
 * @author LiuPing
 * @since 2017年4月19日
 */
@Service
public class RoleAccessServiceImpl implements RoleAccessService {

	@Autowired
	private RoleAccessMapper roleAccessMapper;
	
	public List<Integer> getPermissionIdsByRoleId(int roleId) {
		return roleAccessMapper.getPermissionIdByRoleId(roleId);
	}

	public void add(Integer roleId, int permissionId) {
		RoleAccessInfo obj = new RoleAccessInfo();
		obj.setRoleId(roleId);
		obj.setPermissionId(permissionId);
		roleAccessMapper.addRoleAccess(obj );
	}

	public void del(Integer roleId, int permissionId) {
		roleAccessMapper.del(roleId, permissionId);
	}

}
