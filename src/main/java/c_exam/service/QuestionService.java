package c_exam.service;

import c_exam.pojo.dao.QuestionInfo;
import c_exam.util.Page;

public interface QuestionService {

	Page<QuestionInfo> getQuestionByPage(int pageNum, int pageSize);

	int getTotal(String type);
	
}
