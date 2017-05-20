package c_exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c_exam.mapper.RoleMapper;
import c_exam.pojo.dao.RoleInfo;
import c_exam.service.RoleService;

/**
 * @author LiuPing
 * @since 2017年4月26日
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	public List<RoleInfo> getRoles() {
		return roleMapper.getRoles();
	}

}
