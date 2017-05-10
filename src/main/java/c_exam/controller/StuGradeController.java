package c_exam.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import c_exam.pojo.dao.ExamSerialInfo;
import c_exam.pojo.dao.QuestionInfo;
import c_exam.pojo.dto.StudentGradeDto;
import c_exam.pojo.dto.UserDto;
import c_exam.service.StuGradeService;
import c_exam.util.AppConstant;

/**
 * @author LiuPing
 * @since 2017年5月10日
 */
@Controller
@RequestMapping("/stuGrade")
public class StuGradeController {

	@Autowired
	private StuGradeService gradeService;

	/**
	 * 学生成绩列表
	 * 
	 * @return
	 */
	@RequestMapping("list")
	public ModelAndView list() {
		Map<String, Object> map = new HashMap<String, Object>();
		gradeService.getStuGradeList();
		map.put("content", "gradeList");
		return new ModelAndView("index");
	}

	/**
	 * 成绩单详情
	 * 
	 * @return
	 */
	@RequestMapping("reportList")
	public ModelAndView reportList(HttpSession session) {
		UserDto user = (UserDto) session.getAttribute(AppConstant.CUR_USER);
		ExamSerialInfo exam = (ExamSerialInfo) session.getAttribute(AppConstant.CUR_EXAM);
		StudentGradeDto grade = gradeService.getReport(user.getId(), exam.getId());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("content", "report");
		return new ModelAndView("index");
	}

}
