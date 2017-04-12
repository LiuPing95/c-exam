package c_exam.pojo.dao;

import java.io.Serializable;

/**
 * 系别信息
 * 
 * @author LiuPing
 * @since 2017年4月11日
 */
public class DeptInfo implements Serializable {

	private static final long serialVersionUID = -878284305954335029L;

	private int id;

	private String name;

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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}
