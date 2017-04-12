package c_exam.pojo.dao;

import java.io.Serializable;

/**
 * 学生答题信息
 * 
 * @author LiuPing
 * @since 2017年4月11日
 */
public class StudentAnswerInfo implements Serializable {

	private static final long serialVersionUID = 8183671098467908984L;

	private int id;
	
	private int stuId;
	
	private int questionId;
	
	private int examId;
	
	private String answer;
	
	private String createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}
