package c_exam.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import c_exam.pojo.dao.ExamQuestionType;
import c_exam.pojo.dao.QuestionInfo;
import c_exam.service.ExamQuestionTypeService;
import c_exam.service.GenerateExamService;
import c_exam.service.QuestionService;

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

	@Autowired
	private QuestionService questionService;

	@RequestMapping("/h/h/addType")
	@ResponseBody
	public boolean addType(Integer sum, String type) {
		ExamQuestionType obj = new ExamQuestionType();
		obj.setExamId(0);
		obj.setSum(sum == null ? 10 : sum);
		obj.setType(type);
		typeService.addType(obj);
		return true;
	}
	
	@RequestMapping("/h/h/del")
	@ResponseBody
	public boolean del(Integer id) {
		typeService.del(id);
		return true;
	}
	
	@RequestMapping("list")
	public ModelAndView list() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> types = questionService.getTypes();
		List<ExamQuestionType> examTypes = typeService.getAll();
		for (ExamQuestionType eq : examTypes) {
			if(types.contains(eq.getType())) {
				types.remove(eq.getType());
			}
		}
		map.put("types", types);
		map.put("examTypes", examTypes);
		map.put("content", "questionType");
		return new ModelAndView("index").addAllObjects(map);
	}

	/**
	 * 根据某个题型信息，生成试卷，生成完了之后显示生成的试卷
	 * 
	 * @return
	 */
	@RequestMapping("generate")
	public ModelAndView generate() {
		List<QuestionInfo> list = genService.generateQuestions();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("content", "exam");
		map.put("questions", list);
		return new ModelAndView("index").addAllObjects(map);
	}
}
