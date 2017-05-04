package c_exam.service;

import java.util.List;

import c_exam.pojo.dao.QuestionInfo;

public interface QuestionService {

	List<QuestionInfo> getQuestionByPage(int pageNum, int pageSize);

	int getTotal(String type);

	List<String> getTypes();
	
}
