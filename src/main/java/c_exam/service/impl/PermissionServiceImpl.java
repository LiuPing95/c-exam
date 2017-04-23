package c_exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c_exam.mapper.PermissionMapper;
import c_exam.pojo.dao.PermissionInfo;
import c_exam.service.PermissionService;

/**
 * @author LiuPing
 * @since 2017年4月16日
 */
@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionMapper mapper;

	public List<PermissionInfo> getByIds(List<Integer> list) {
		return mapper.getByIds(list);
	}

	public List<PermissionInfo> getAll() {
		return mapper.getAll();
	}

}
