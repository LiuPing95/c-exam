package c_exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import c_exam.mapper.QuestionMapper;
import c_exam.pojo.dao.QuestionInfo;
import c_exam.util.Page;

/**
 * @author LiuPing
 * @since 2017年3月28日
 */
@Controller
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionMapper questionMapper;
	
	@RequestMapping("list")
	public ModelAndView list(Page<QuestionInfo> page) {
		page.setData(questionMapper.getQuestionByPage(page.getPageNum(), page.getPageSize()));
		return new ModelAndView("index").addObject("page", page);
	}
}
