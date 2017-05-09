package c_exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c_exam.mapper.ClassMapper;
import c_exam.pojo.dao.ClassInfo;
import c_exam.service.ClassService;

/**
 * @author LiuPing
 * @since 2017年5月4日
 */
@Service
public class ClassServiceImpl implements ClassService {

	@Autowired
	private ClassMapper mapper;
	
	public List<ClassInfo> getClasses() {
		return mapper.getClasses();
	}

}
