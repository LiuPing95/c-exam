package c_exam.service;

import java.util.List;

import c_exam.pojo.dao.QuestionInfo;

public interface QuestionService {

	List<QuestionInfo> getQuestionByPage(int pageNum, int pageSize, String type, String content);
	
	List<QuestionInfo> getQuestionByIds(List<Integer> ids);

	int getTotal(String type, String content);

	List<String> getTypes();

	void add(QuestionInfo obj);

	void del(Integer id);

	QuestionInfo getQuestionById(Integer id);

	void update(QuestionInfo obj);
	
}
