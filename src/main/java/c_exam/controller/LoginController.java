package c_exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author LiuPing
 * @since 2017年3月28日
 */
@Controller
@RequestMapping("/*")
public class LoginController {
	
	@RequestMapping("")
	public ModelAndView login() {
		return new ModelAndView("login");
	}
}
