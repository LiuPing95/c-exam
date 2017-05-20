package c_exam.pojo.dao;

import java.io.Serializable;

/**
 * 学生成绩信息
 * 
 * @author LiuPing
 * @since 2017年4月11日
 */
public class StudentGradeInfo implements Serializable {

	private static final long serialVersionUID = 5854888645042439752L;

	private int id;

	private int examId;
	
	private int stuId;

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	private int grade;

	private String createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}
