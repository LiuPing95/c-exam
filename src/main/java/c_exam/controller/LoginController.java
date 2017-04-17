package c_exam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import c_exam.pojo.dto.UserDto;
import c_exam.service.UserService;
import c_exam.util.UserConstant;

/**
 * @author LiuPing
 * @since 2017年3月28日
 */
@Controller
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("info")
	public ModelAndView showInfo(HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserDto user = (UserDto) session.getAttribute(UserConstant.CUR_USER);
		return new ModelAndView("index").addObject("content", "userEdit").addObject("user", user);
	}
	
	@RequestMapping("toLogin")
	public ModelAndView toLogin() {
		return new ModelAndView("login");
	}
	
	@RequestMapping("loginIn")
	public ModelAndView loginIn(HttpServletRequest request) {
		// 查询是否存在这个用户
//		USerDto user = userService.userLogin();
		UserDto user = new UserDto();
		user.setBirthday("2010-01-02");
		user.setName("apple");
		user.setPhone("1567597565");
		user.setGender("男");
		request.getSession().setAttribute(UserConstant.CUR_USER, user);
//		return new ModelAndView("index").addObject("content", "question");
		return new ModelAndView("login").addObject("msg", "NO");
	}
	
	@RequestMapping("loginOut")
	public ModelAndView loginOut(HttpSession session) {
		session.removeAttribute(UserConstant.CUR_USER);
		return new ModelAndView("login");
	}
	
}
