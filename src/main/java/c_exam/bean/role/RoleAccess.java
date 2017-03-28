package c_exam.bean.role;

/**
 * 角色对应的权限
 * 
 * @author LiuPing
 * @since 2017年3月19日
 */
public class RoleAccess {

	private int id;
	
	private String name;
	
	private String url;
	
	private String occurTime;

	public String getOccurTime() {
		return occurTime;
	}

	public void setOccurTime(String occurTime) {
		this.occurTime = occurTime;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
