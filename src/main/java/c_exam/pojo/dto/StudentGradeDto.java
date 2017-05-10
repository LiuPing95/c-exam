package c_exam.pojo.dto;

import java.io.Serializable;

/**
 * 学生成绩信息传输对象
 * 
 * @author LiuPing
 * @since 2017年4月11日
 */
public class StudentGradeDto implements Serializable {

	private static final long serialVersionUID = 5854888645042439752L;

	private int id;

	private int examId;
	
	private String examName;
	
	private int stuId;
	
	private String stuName;

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
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
