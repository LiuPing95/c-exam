package c_exam.pojo.dao;

import java.io.Serializable;

/**
 * 班级信息
 * 
 * @author LiuPing
 * @since 2017年4月11日
 */
public class ClassInfo implements Serializable {

	private static final long serialVersionUID = -3473329061177282814L;

	private int id;
	
	private String name;
	
	private int deptId;
	
	private String createTime;

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

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}
