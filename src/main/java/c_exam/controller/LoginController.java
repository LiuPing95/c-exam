package c_exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author LiuPing
 * @since 2017年3月28日
 */
@Controller
@RequestMapping("/")
public class LoginController {
	
	@RequestMapping("toLogin")
	public ModelAndView toLogin() {
		return new ModelAndView("login");
	}
	
	@RequestMapping("loginIn")
	public ModelAndView loginIn() {
		// 查询是否存在这个用户
		// 
		return new ModelAndView("index").addObject("content", "question");
	}
	
	@RequestMapping("loginOut")
	public ModelAndView loginOut() {
		return new ModelAndView("login");
	}
	
}
