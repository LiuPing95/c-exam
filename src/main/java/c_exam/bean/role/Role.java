package c_exam.bean.role;

import java.util.List;

/**
 * 角色
 * 
 * @author LiuPing
 * @since 2017年3月19日
 */
public class Role {

	private int id;
	
	private String name;
	
	private String desc;
	
	/**
	 * 角色对应的权限列表
	 */
	private List<RoleAccess> accessList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<RoleAccess> getAccessList() {
		return accessList;
	}

	public void setAccessList(List<RoleAccess> accessList) {
		this.accessList = accessList;
	}
	
}
