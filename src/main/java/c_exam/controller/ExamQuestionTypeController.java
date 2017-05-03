package c_exam.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import c_exam.pojo.dao.QuestionInfo;
import c_exam.service.ExamQuestionTypeService;
import c_exam.service.GenerateExamService;

/**
 * @author LiuPing
 * @since 2017年5月1日
 */
@Controller
@RequestMapping("/questionType")
public class ExamQuestionTypeController {

	@Autowired
	private ExamQuestionTypeService typeService;
	
	@Autowired
	private GenerateExamService genService;
	
	@RequestMapping("list")
	public ModelAndView list() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("types", typeService.getAll());
		map.put("content", "questionType");
		return new ModelAndView("index").addAllObjects(map);
	}
	
	/**
	 * 根据某个题型信息，生成试卷，生成完了之后显示生成的试卷
	 * @return
	 */
	@RequestMapping("generate")
	public ModelAndView generate(Integer examId) {
		Map<String, List<QuestionInfo>> map = genService.generateQuestionIds(examId);
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.putAll(map);
		modelMap.put("content", "exam");
		modelMap.put("", "");
		return new ModelAndView("index").addAllObjects(modelMap);
	}
}
