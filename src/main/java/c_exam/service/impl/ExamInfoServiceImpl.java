package c_exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c_exam.mapper.ExamMapper;
import c_exam.pojo.dao.ExamInfo;
import c_exam.service.ExamInfoService;

/**
 * @author LiuPing
 * @since 2017年5月8日
 */
@Service
public class ExamInfoServiceImpl implements ExamInfoService {

	@Autowired
	private ExamMapper mapper;
	
	public void add(ExamInfo obj) {
		mapper.addExam(obj);
	}

	public List<Integer> getQuestionIdsByExamId(int id) {
		return mapper.getQuestionIdsByExamId(id);
	}

	public void clear(int id) {
		mapper.del(id);
	}

}
