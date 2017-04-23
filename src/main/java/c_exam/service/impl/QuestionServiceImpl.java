package c_exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c_exam.mapper.QuestionMapper;
import c_exam.pojo.dao.QuestionInfo;
import c_exam.service.QuestionService;
import c_exam.util.Page;

/**
 * @author LiuPing
 * @since 2017年4月16日
 */
@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionMapper mapper;

	public Page<QuestionInfo> getQuestionByPage(int pageNum, int pageSize) {
		Page<QuestionInfo> page = new Page<QuestionInfo>();
		page.setData(mapper.getQuestionByPage((pageNum - 1) * pageSize, pageSize));
		page.setTotalPage(mapper.getTotal(null) / pageSize);
		return page;
	}

	public int getTotal(String type) {
		return mapper.getTotal(type);
	}

}
