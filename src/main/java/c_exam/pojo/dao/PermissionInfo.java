package c_exam.pojo.dao;

/**
 * @author LiuPing
 * @since 2017年4月11日
 */
public class PermissionInfo {

	private int id;
	
	private String name;
	
	private String url;
	
	private String forDesc;
	
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
