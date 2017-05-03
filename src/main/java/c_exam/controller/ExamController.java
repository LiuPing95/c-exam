package c_exam.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import c_exam.pojo.dao.ExamSerialInfo;
import c_exam.service.ExamSerialService;

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
	
	@RequestMapping("list")
	public ModelAndView list(HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("content", "examSerial");
		map.put("list", serialService.getAll());
		return new ModelAndView("index").addAllObjects(map);
	}
	
	@RequestMapping("toEdit")
	public ModelAndView toedit(String action, Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("content", "serialEdit");
		if("edit".equals(action)){
			map.put("serial", serialService.getById(id));
		}
		return new ModelAndView("index").addAllObjects(map);
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
