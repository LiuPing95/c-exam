package c_exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户信息访问
 * 
 * @author LiuPing
 * @since 2017年3月19日
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("list")
	public ModelAndView list() {
		ModelAndView m = new ModelAndView("");
		return m;
	}
}
