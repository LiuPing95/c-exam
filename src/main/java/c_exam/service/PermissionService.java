package c_exam.service;

import java.util.List;

import c_exam.pojo.dao.PermissionInfo;

public interface PermissionService {
	
	List<PermissionInfo> getByIds(List<Integer> list);

	List<PermissionInfo> getAll();
	
}
