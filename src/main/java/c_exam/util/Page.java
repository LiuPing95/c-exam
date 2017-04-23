package c_exam.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuPing
 * @param <T>
 * @since 2017年4月14日
 */
public class Page<T> {
	
	private int pageNum = 1;
	
	private int pageSize = 10;
	
	/**
	 * TODO：每次查询都会查询一次总数据量，能不能只查一次
	 * 总数据量
	 */
	private int total;
	
	private int totalPage;
	
	private List<T> data = new ArrayList<T>();

	public int getPageNum() {
		return pageNum <= 0 ? 1 : pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize <= 0 ? 10 : pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
}
