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
import c_exam.service.ClassService;
import c_exam.service.DeptService;
import c_exam.service.RoleService;
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
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private ClassService classService;
	
	@Autowired
	private DeptService deptService;
	
	@RequestMapping("toEdit")
	public ModelAndView edit(Integer userId, String action, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		if ("edit".equals(action)) {
			UserDto user = userService.getUserById(userId);
			map.put("user", user);
		}
		map.put("action", action);
		map.put("roles", roleService.getRoles());
		map.put("classes", classService.getClasses());
		map.put("depts", deptService.getDepts());
		map.put("content", "userEdit");
		return new ModelAndView("index").addAllObjects(map);
	}
	
	@RequestMapping("add")
	public String add(UserInfo user) {
		if(user.getAddr() == null) {
			user.setAddr("");
		}
		if(user.getPhone() == null) {
			user.setPhone("");
		}
		if(user.getBirthday() == null) {
			user.setBirthday("");
		}
		if(user.getCollege() == null) {
			user.setCollege("衡阳师范学院");
		}
		if(user.getIdCard() == null) {
			user.setIdCard("");
		}
		userService.add(user);
		return "redirect:/user/list";
	}
	
	@RequestMapping("edit")
	public String edit(UserDto user) {
		userService.updateUser(user);
		return "redirect:/user/list";
	}
	
	@RequestMapping("del")
	public String del(Integer id) {
		userService.del(id);
		return "redirect:/user/list";
	}

	@RequestMapping("list")
	public ModelAndView list() {
		List<UserDto> users = userService.getUserByPage(1, 10);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("content", "userList");
		map.put("users", users);
		return new ModelAndView("index").addAllObjects(map);
	}
}
