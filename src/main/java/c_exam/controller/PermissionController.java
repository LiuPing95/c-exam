package c_exam.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import c_exam.pojo.dao.PermissionInfo;
import c_exam.service.PermissionService;

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
	public ModelAndView list() {
		// 因为权限并不是很多，可以先不做分页
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("content", "permission");
		map.put("list", permissionService.getAll());
		return new ModelAndView("index").addAllObjects(map);
	}
	
	@RequestMapping("toEdit")
	public ModelAndView toAdd(String action, Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		if ("add".equals(action)) {
			map.put("action", "add");
		}
		if ("edit".equals(action)) {
			map.put("action", "edit");
			map.put("permission", permissionService.getById(id));
		}
		map.put("content", "permissionEdit");
		return new ModelAndView("index").addAllObjects(map);
	}
	
	@RequestMapping("add")
	public String add(PermissionInfo obj) {
		permissionService.add(obj);
		return "redirect:/permission/list";
	}
	
	@RequestMapping("edit")
	public String edit(PermissionInfo obj) {
		permissionService.update(obj);
		return "redirect:/permission/list";
	}
	
	@RequestMapping("del")
	public String del(Integer id) {
		permissionService.del(id);
		return "redirect:/permission/list";
	}
	
}
