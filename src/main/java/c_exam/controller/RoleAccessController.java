package c_exam.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import c_exam.service.PermissionService;
import c_exam.service.RoleAccessService;
import c_exam.service.RoleService;

/**
 * @author LiuPing
 * @since 2017年4月26日
 */
@Controller
@RequestMapping("/roleAccess")
public class RoleAccessController {

	@Autowired
	private RoleAccessService roleAccessService;
	
	@Autowired
	private PermissionService permissionService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("roleList")
	public ModelAndView roleList() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("content", "role");
		map.put("roles", roleService.getRoles());
		return new ModelAndView("index").addAllObjects(map);
	}
	
	@RequestMapping("del")
	public boolean del(Integer id) {
		return true;
	}
	
	@RequestMapping("list")
	public ModelAndView list(Integer roleId, String action) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Integer> ids = roleAccessService.getPermissionIdsByRoleId(roleId);
		if("auth".equals(action)) {
			map.put("permission", permissionService.getRemainPermission(ids.size() == 0 ? null : ids));
		}
		if("unauth".equals(action)) {
			map.put("permission", permissionService.getByIds(ids.size() == 0 ? null : ids));
		}
		map.put("roleId", roleId);
		map.put("action", action);
		map.put("content", "roleAccess");
		return new ModelAndView("index").addAllObjects(map);
	}
	
	@RequestMapping("/h/h/authorize")
	@ResponseBody
	public boolean authorize(String action, String ids, Integer roleId) {
		if("auth".equals(action)) {
			for (String s : ids.split("_")) {
				roleAccessService.add(roleId, Integer.parseInt(s));
			}
		}
		if("unauth".equals(action)) {
			for (String s : ids.split("_")) {
				roleAccessService.del(roleId, Integer.parseInt(s));
			}
		}
		return true;
	}
	
}
