package c_exam.service;

import java.util.List;

public interface RoleAccessService {
	
	List<Integer> getPermissionIdsByRoleId(int roleId);

	void add(Integer roleId, int permissionId);

	void del(Integer roleId, int permissionId);

}
