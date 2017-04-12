package c_exam.pojo.dao;

/**
 * 学生成绩信息
 * 
 * @author LiuPing
 * @since 2017年4月11日
 */
public class StudentGradeInfo {

	private int id;

	private int examId;

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