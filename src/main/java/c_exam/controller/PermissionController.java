package c_exam.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import c_exam.service.PermissionService;
import c_exam.util.UserConstant;

/**
 * 权限管理
 * 
 * @author LiuPing
 * @since 2017年4月20日
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {
	
	@Autowired
	private PermissionService permissionService;
	
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("content", "permission");
		map.put("user", request.getSession().getAttribute(UserConstant.CUR_USER));
		map.put("permission", request.getSession().getAttribute(UserConstant.CUR_PERMISSION));
		map.put("list", permissionService.getAll());
		return new ModelAndView("index").addAllObjects(map);
	}
	
	
	/**
	 * 添加权限，这个应该是异步操作
	 * @return
	 */
	@RequestMapping("add")
	@ResponseBody
	public boolean add() {
		return true;
	}
}
