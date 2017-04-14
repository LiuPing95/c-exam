package c_exam.pojo.dao;

/**
 * 考试题型
 * 
 * @author LiuPing
 * @since 2017年4月14日
 */
public class ExamQuestionType {

	private int id;
	
	/**
	 * 哪一次考试
	 */
	private int examId;
	
	/**
	 * 考试的题型
	 */
	private String type;
	
	/**
	 * 该题型的数量
	 */
	private int sum;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
	
}
