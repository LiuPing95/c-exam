package c_exam.service;

import java.util.List;

import c_exam.pojo.dao.StudentAnswerInfo;

public interface StuAnswerService {

	List<StudentAnswerInfo> getAnswer();

	void add(StudentAnswerInfo obj);
}
