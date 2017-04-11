package c_exam.pojo.dao;

import java.util.List;

/**
 * 角色
 * 
 * @author LiuPing
 * @since 2017年3月19日
 */
public class RoleInfo {

	private int id;

	private String name;

	private String forDesc;

	private String createTime;

	/**
	 * 角色对应的权限列表
	 */
	private List<RoleAccessInfo> accessList;

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

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

	public String getForDesc() {
		return forDesc;
	}

	public void setForDesc(String forDesc) {
		this.forDesc = forDesc;
	}

	public List<RoleAccessInfo> getAccessList() {
		return accessList;
	}

	public void setAccessList(List<RoleAccessInfo> accessList) {
		this.accessList = accessList;
	}

}
