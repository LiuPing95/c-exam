package c_exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c_exam.mapper.StudentAnswerMapper;
import c_exam.pojo.dao.StudentAnswerInfo;
import c_exam.pojo.dto.StudentAnswerDto;
import c_exam.service.StuAnswerService;

/**
 * @author LiuPing
 * @since 2017年5月5日
 */
@Service
public class StuAnswerServiceImpl implements StuAnswerService {

	@Autowired
	private StudentAnswerMapper mapper;
	
	public List<StudentAnswerInfo> getAnswer() {
		return null;
	}

	public void add(StudentAnswerInfo obj) {
		mapper.addStudentAnswer(obj);
	}

	public List<StudentAnswerInfo> getStuAnswers(Integer userId, Integer examId) {
		return mapper.getAnswerByUser(userId, examId);
	}

	public List<StudentAnswerDto> getStuAnswerDtos(Integer stuId, Integer examId) {
		return mapper.getAnswerDtoByUser(stuId, examId);
	}

}
