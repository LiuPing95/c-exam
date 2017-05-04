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

	public List<QuestionInfo> getQuestionByPage(int pageNum, int pageSize) {
		return mapper.getQuestionByPage((pageNum - 1) * pageSize, pageNum * pageSize);
	}

	public int getTotal(String type) {
		return mapper.getTotal(type);
	}

	public List<String> getTypes() {
		return mapper.getTypes();
	}

}
