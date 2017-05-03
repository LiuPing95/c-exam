package c_exam.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import c_exam.pojo.dao.UserInfo;
import c_exam.pojo.dto.UserDto;
import c_exam.service.UserService;
import c_exam.util.UserConstant;

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
	public ModelAndView edit(Integer userId, String action, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		if ("edit".equals(action)) {
			UserDto user = userService.getUserById(userId);
			map.put("user", user);
		}
		map.put("curUser", session.getAttribute(UserConstant.CUR_USER));
		map.put("content", "userEdit");
		return new ModelAndView("index").addAllObjects(map);
	}
	
	@RequestMapping("add")
	public String add(UserInfo user) {
//		if(user.getAddr() == null) {
//			user.setAddr("");
//		}
//		if(user.getBirthday() == null) {
//			user.setBirthday("");
//		}
//		if(user.getCollege() == null) {
//			user.setCollege("衡阳师范学院");
//		}
//		if(user.getIdCard() == null) {
//			user.setIdCard("");
//		}
		userService.add(user);
		return "redirect:/user/list";
	}
	
	@RequestMapping("edit")
	public boolean edit(UserDto user) {
		userService.updateUser(user);
		return true;
	}

	@RequestMapping("list")
	public ModelAndView list() {
		List<UserDto> users = userService.getUserByPage(1, 10);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("content", "userList");
		map.put("users", users);
		map.put("", "");
		return new ModelAndView("index").addAllObjects(map);
	}
}
