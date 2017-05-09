package c_exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c_exam.mapper.QuestionMapper;
import c_exam.pojo.dao.QuestionInfo;
import c_exam.service.QuestionService;

/**
 * @author LiuPing
 * @since 2017年4月16日
 */
@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionMapper mapper;

	public int getTotal(String type, String content) {
		return mapper.getTotal(type, content);
	}

	public List<String> getTypes() {
		return mapper.getTypes();
	}

	public void add(QuestionInfo obj) {
		mapper.addQuestion(obj);
	}

	public List<QuestionInfo> getQuestionByPage(int pageNum, int pageSize, String type, String content) {
		return mapper.getQuestionByPage((pageNum - 1) * pageSize, pageNum * pageSize, type, content);
	}

	public void del(Integer id) {
		mapper.del(id);
	}

	public List<QuestionInfo> getQuestionByIds(List<Integer> ids) {
		return mapper.getQuestionByIds(ids);
	}

}
