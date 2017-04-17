package c_exam.service;

import java.util.List;

import c_exam.pojo.dao.QuestionInfo;

public interface QuestionService {

	List<QuestionInfo> getQuestionByPage(Integer pageNum, Integer pageSize);

	void batchAdd(List<QuestionInfo> list);
	
}
