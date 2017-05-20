package c_exam.service;

import java.util.List;

import c_exam.pojo.dao.PermissionInfo;

public interface PermissionService {
	
	List<PermissionInfo> getByIds(List<Integer> list);

	List<PermissionInfo> getAll();

	void add(PermissionInfo obj);

	List<PermissionInfo> getRemainPermission(List<Integer> ids);

	void del(Integer id);

	void update(PermissionInfo obj);

	PermissionInfo getById(Integer id);

}
