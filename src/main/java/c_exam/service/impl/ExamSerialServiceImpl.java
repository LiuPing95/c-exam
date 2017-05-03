package c_exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c_exam.mapper.ExamSerialMapper;
import c_exam.pojo.dao.ExamSerialInfo;
import c_exam.service.ExamSerialService;

/**
 * @author LiuPing
 * @since 2017年5月3日
 */
@Service
public class ExamSerialServiceImpl implements ExamSerialService {

	@Autowired
	private ExamSerialMapper serialMapper;
	
	public List<ExamSerialInfo> getAll() {
		return serialMapper.getAll();
	}

	public ExamSerialInfo getById(Integer id) {
		return serialMapper.getExamSerialInfoById(id);
	}

	public void add(ExamSerialInfo obj) {
		serialMapper.addExamSerial(obj);
	}

	public void del(Integer id) {
		serialMapper.del(id);
	}

}
