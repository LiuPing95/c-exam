package c_exam.pojo.dao;

import java.io.Serializable;

/**
 * @author LiuPing
 * @since 2017年4月11日
 */
public class ExamSerialInfo implements Serializable {

	private static final long serialVersionUID = -8684498358591353293L;

	private int id;
	
	private String forDesc;
	
	private String createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getForDesc() {
		return forDesc;
	}

	public void setForDesc(String forDesc) {
		this.forDesc = forDesc;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}
