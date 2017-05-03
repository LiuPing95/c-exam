package c_exam.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import c_exam.pojo.dao.PermissionInfo;
import c_exam.pojo.dao.UserInfo;
import c_exam.pojo.dto.UserDto;
import c_exam.service.PermissionService;
import c_exam.service.RoleAccessService;
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

	@Autowired
	private RoleAccessService roleAccessService;

	@Autowired
	private PermissionService permissionService;

	@RequestMapping("index")
	public ModelAndView index() {
		return new ModelAndView("index").addObject("content", "cover");
	}

	@RequestMapping("info")
	public ModelAndView showInfo() {
		return new ModelAndView("index").addObject("content", "currUser");
	}

	@RequestMapping("/h/h/loginIn")
	@ResponseBody
	public boolean loginIn(HttpServletRequest request) {
		String userName = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		UserInfo user = new UserInfo();
		user.setPwd(pwd);
		if (userName.length() == 11) {
			user.setPhone(userName);
		}
		if (userName.length() == 18) {
			user.setIdCard(userName);
		}
		try {
			if (userName.length() == 6) {
				// 如果这里出现异常说明不是数字
				user.setId(Integer.parseInt(userName));
			}
		} catch (NumberFormatException e) {
			return false;
		}
		// 查询是否存在这个用户
		UserDto loginUser = userService.userLogin(user);
		if (loginUser == null) {
			return false;
		}
		// 用户存在的话查出这个用户拥有的权限
		List<Integer> ids = roleAccessService.getPermissionIdsByRoleId(loginUser.getRoleId());
		List<PermissionInfo> permissions = permissionService.getByIds(ids);
		request.getSession().setAttribute(UserConstant.CUR_USER, loginUser);
		request.getSession().setAttribute(UserConstant.CUR_PERMISSION, permissions);
		request.getSession().setMaxInactiveInterval(120 * 60);
		return true;
	}

	@RequestMapping(value = { "loginOut", "login" })
	public String loginOut(HttpSession session) {
		session.invalidate();
		return "login";
	}

}
