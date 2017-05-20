package c_exam.service;

import java.util.List;

import c_exam.pojo.dao.StudentAnswerInfo;
import c_exam.pojo.dto.StudentAnswerDto;

public interface StuAnswerService {

	List<StudentAnswerInfo> getAnswer();

	void add(StudentAnswerInfo obj);

	List<StudentAnswerInfo> getStuAnswers(Integer userId, Integer examId);

	List<StudentAnswerDto> getStuAnswerDtos(Integer stuId, Integer examId);
}
