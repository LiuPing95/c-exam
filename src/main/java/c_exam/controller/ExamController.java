package c_exam.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import c_exam.pojo.dao.ExamInfo;
import c_exam.pojo.dao.ExamSerialInfo;
import c_exam.pojo.dao.StudentAnswerInfo;
import c_exam.pojo.dto.UserDto;
import c_exam.service.ExamInfoService;
import c_exam.service.ExamSerialService;
import c_exam.service.QuestionService;
import c_exam.service.StuAnswerService;
import c_exam.util.AppConstant;

/**
 * 考试：教师生成考试信息，设定考试题型，抽取考题，完成出卷
 * 
 * @author LiuPing
 * @since 2017年4月30日
 */
@Controller
@RequestMapping("/examSerial")
public class ExamController {

	@Autowired
	private ExamSerialService serialService;

	@Autowired
	private ExamInfoService examService;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private StuAnswerService answerService;

	@RequestMapping("list")
	public ModelAndView list() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("content", "examSerial");
		map.put("list", serialService.getAll());
		return new ModelAndView("index").addAllObjects(map);
	}

	@RequestMapping("examList")
	public ModelAndView examList(HttpSession session) {
		// 在学生准备考试时，先查询有没有考试过，考试过就不能再考试了
		UserDto user = (UserDto) session.getAttribute(AppConstant.CUR_USER);
		ExamSerialInfo exam = (ExamSerialInfo) session.getAttribute(AppConstant.CUR_EXAM);
		List<StudentAnswerInfo> stuAnswer = answerService.getStuAnswers(user.getId(), exam.getId());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("content", "exam");
		if (stuAnswer.size() <= 0) {
			ExamSerialInfo serialInfo = (ExamSerialInfo) session.getAttribute(AppConstant.CUR_EXAM);
			List<Integer> questionIds = examService.getQuestionIdsByExamId(serialInfo.getId());
			map.put("questions", questionService.getQuestionByIds(questionIds));
		}
		else {
			map.put("msg", "你已经参加过考试不能重复考试，请等待考试结果");
		}
		return new ModelAndView("index").addAllObjects(map);
	}

	@RequestMapping("toEdit")
	public ModelAndView toedit(String action, Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("content", "serialEdit");
		if ("edit".equals(action)) {
			map.put("serial", serialService.getById(id));
		}
		map.put("action", action);
		return new ModelAndView("index").addAllObjects(map);
	}

	@RequestMapping("confirm")
	@ResponseBody
	public boolean confirm(HttpSession session, String str) {
		// 确认使用该套试题之前把前面的删掉
		str = str.substring(0, str.length() - 1);
		String[] arr = str.split("_");
		ExamSerialInfo info = (ExamSerialInfo) session.getAttribute(AppConstant.CUR_EXAM);
		examService.clear(info.getId());
		List<Integer> questionIds = new ArrayList<Integer>();
		for (String s : arr) {
			ExamInfo obj = new ExamInfo();
			obj.setExamId(info.getId());
			obj.setQuestionId(Integer.parseInt(s));
			questionIds.add(Integer.parseInt(s));
			examService.add(obj);
		}
		session.setAttribute(AppConstant.CUR_QUESTION, questionIds);
		return true;
	}

	@RequestMapping("forUse")
	public String forUse(HttpSession session, Integer id) {
		serialService.forUse(id);
		session.setAttribute(AppConstant.CUR_EXAM, serialService.getCur());
		return "redirect:/examSerial/list";
	}

	@RequestMapping("add")
	public String add(ExamSerialInfo obj) {
		serialService.add(obj);
		return "redirect:/examSerial/list";
	}

	@RequestMapping("del")
	public String del(Integer id) {
		serialService.del(id);
		return "redirect:/examSerial/list";
	}
}
