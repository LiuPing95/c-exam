package c_exam.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import c_exam.pojo.dao.ExamSerialInfo;
import c_exam.pojo.dao.StudentAnswerInfo;
import c_exam.pojo.dao.StudentGradeInfo;
import c_exam.pojo.dto.UserDto;
import c_exam.service.ExamSerialService;
import c_exam.service.StuAnswerService;
import c_exam.service.StuGradeService;
import c_exam.util.AppConstant;

/**
 * @author LiuPing
 * @since 2017年5月5日
 */
@Controller
@RequestMapping("/stuAnswer")
public class StuAnswerController {

	@Autowired
	private StuAnswerService answerService;
	
	@Autowired
	private StuGradeService gradeService;
	
	@Autowired
	private ExamSerialService serialService;
	
	@RequestMapping("list")
	public void list() {
		
	}
	
	@RequestMapping("add")
	@ResponseBody
	public boolean add(String str, HttpSession session) {
		str = str.substring(0, str.length()-1);
		String[] arr = str.split("&");
		ExamSerialInfo exam = serialService.getCur();
		UserDto user = (UserDto) session.getAttribute(AppConstant.CUR_USER);
		System.out.println(str);
		for (String s : arr) {
			String[] arr1 = s.split("_");
			StudentAnswerInfo obj = new StudentAnswerInfo();
			obj.setQuestionId(Integer.parseInt(arr1[0]));
			obj.setAnswer(arr1[1]);
			obj.setStuId(user.getId());
			obj.setExamId(exam.getId());
			answerService.add(obj);
		}
		StudentGradeInfo grade = new StudentGradeInfo();
		grade.setExamId(exam.getId());
		grade.setStuId(user.getId());
		grade.setGrade(-1);
		gradeService.addStuGrade(grade);
		return true;
	}
	
	@RequestMapping("submit")
	@ResponseBody
	public boolean submit(HttpSession session, String str) {
		str = str.substring(0, str.length()-1);
		String[] arr = str.split("&");
		for (String s : arr) {
			String[] arr1 = s.split("_");
			StudentAnswerInfo obj = new StudentAnswerInfo();
			obj.setExamId(Integer.parseInt(arr1[0]));
			obj.setAnswer(arr[1]);
			answerService.add(obj);
		}
		// 当用户点击交卷，从session中取出学生答题的记录，存到数据库中
		UserDto user = (UserDto) session.getAttribute(AppConstant.CUR_USER);
		session.getAttribute(user.getId() + "");
		
		StudentAnswerInfo obj = new StudentAnswerInfo();
		answerService.add(obj);
		return true;
	}
	
}
