package c_exam.pojo.dao;

import java.io.Serializable;

/**
 * 角色对应的权限
 * 
 * @author LiuPing
 * @since 2017年3月19日
 */
public class RoleAccessInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3620806470109078389L;

	private int id;

	private int roleId;
	
	private int permissionId;

	private String occurTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}

	public String getOccurTime() {
		return occurTime;
	}

	public void setOccurTime(String occurTime) {
		this.occurTime = occurTime;
	}

}
