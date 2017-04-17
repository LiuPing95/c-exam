package c_exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import c_exam.pojo.dto.UserDto;
import c_exam.service.UserService;

/**
 * 用户信息访问
 * 
 * @author LiuPing
 * @since 2017年3月19日
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("toEdit")
	public ModelAndView edit(Integer userId) {
		UserDto user = userService.getUserById(userId);
		return new ModelAndView("index").addObject("content", "userEdit").addObject("user", user);
	}
	
	@RequestMapping("edit")
	public String edit(UserDto user) {
		try {
			userService.updateUser(user);
		} catch (Exception e) {
			return "NO";
		}
		return "OK";
	}

	@RequestMapping("list")
	public ModelAndView list() {
		List<UserDto> users = userService.getUserByPage(1, 2);
		return new ModelAndView("index").addObject("content", "userList").addObject("users", users);
	}
}
