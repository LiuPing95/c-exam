package c_exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c_exam.mapper.DeptMapper;
import c_exam.pojo.dao.DeptInfo;
import c_exam.service.DeptService;

/**
 * @author LiuPing
 * @since 2017年5月4日
 */
@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptMapper mapper;
	
	public List<DeptInfo> getDepts() {
		return mapper.getDepts();
	}

}
