package c_exam.pojo.dao;

import java.io.Serializable;

/**
 * @author LiuPing
 * @since 2017年4月11日
 */
public class ExamInfo implements Serializable {

	private static final long serialVersionUID = 7484389035494928184L;

	private int id;
	
	private int questionId;
	
	private int examId;
	
	private String createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}
