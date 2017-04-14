package c_exam.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuPing
 * @param <T>
 * @since 2017年4月14日
 */
public class Page<T> {
	
	private Integer pageNum;
	
	private Integer pageSize;
	
	/**
	 * TODO：每次查询都会查询一次总数据量，能不能只查一次
	 * 总数据量
	 */
	private Integer total;
	
	private List<T> data = new ArrayList<T>();

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
	
}
