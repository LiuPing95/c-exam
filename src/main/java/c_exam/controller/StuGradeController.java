package c_exam.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import c_exam.pojo.dao.ExamSerialInfo;
import c_exam.pojo.dto.StudentAnswerDto;
import c_exam.pojo.dto.StudentGradeDto;
import c_exam.pojo.dto.UserDto;
import c_exam.service.StuAnswerService;
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
	
	@Autowired
	private StuAnswerService answerService;

	/**
	 * 学生成绩列表：有成绩的就直接显示成绩，没有成绩的要显示批阅试卷
	 * 
	 * @return
	 */
	@RequestMapping("list")
	public ModelAndView list() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StudentGradeDto> grades = gradeService.getStuGradeList();
		map.put("content", "gradeList");
		map.put("grades", grades);
		return new ModelAndView("index").addAllObjects(map);
	}
	
	@RequestMapping("/h/h/update")
	@ResponseBody
	public boolean update(Integer stuId, Integer score) {
		if(score == null) {
			score = 0;
		}
		gradeService.updateGrade(stuId, score);
		return true;
	}
	
	/**
	 * 成绩单详情
	 * 
	 * @return
	 */
	@RequestMapping("reportList")
	public ModelAndView reportList(HttpSession session, Integer stuId, Integer examId) {
		if(stuId == null) {
			UserDto user = (UserDto) session.getAttribute(AppConstant.CUR_USER);
			stuId = user.getId();
		}
		if(examId == null) {
			ExamSerialInfo exam = (ExamSerialInfo) session.getAttribute(AppConstant.CUR_EXAM);
			examId = exam.getId();
		}
		StudentGradeDto grade = gradeService.getReport(stuId, examId);
		List<StudentAnswerDto> answers = answerService.getStuAnswerDtos(stuId, examId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("answers", answers);
		map.put("grade", grade);
		map.put("content", "report");
		return new ModelAndView("index").addAllObjects(map);
	}

}
