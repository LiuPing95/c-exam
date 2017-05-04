package c_exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c_exam.mapper.ExamQuestionTypeMapper;
import c_exam.pojo.dao.ExamQuestionType;
import c_exam.service.ExamQuestionTypeService;

/**
 * @author LiuPing
 * @since 2017年5月1日
 */
@Service
public class ExamQuestionTypeServiceImpl implements ExamQuestionTypeService {

	@Autowired
	private ExamQuestionTypeMapper typeMapper;
	
	public List<ExamQuestionType> getAll() {
		return typeMapper.getAll();
	}

	public void addType(ExamQuestionType obj) {
		typeMapper.addExamQuestionType(obj);
	}

	public void del(Integer id) {
		typeMapper.del(id);
	}

}
