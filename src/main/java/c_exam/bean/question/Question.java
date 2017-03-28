package c_exam.bean.question;

/**
 * 题目对象
 * 
 * @author LiuPing
 * @since 2017年3月17日
 */
public class Question {

	private int id;

	private String questionType;

	/**
	 * 题目内容
	 */
	private String content;

	/**
	 * 题目解释
	 */
	private String forComment;

	/**
	 * 选择题的选项，不是选择题就没有
	 */
	private String itemA;

	private String itemB;

	private String itemC;

	private String itemD;

	/**
	 * 题目的答案
	 */
	private String answer;

	/**
	 * 题目添加的时间
	 */
	private String occurTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getForComment() {
		return forComment;
	}

	public void setForComment(String forComment) {
		this.forComment = forComment;
	}

	public String getItemA() {
		return itemA;
	}

	public void setItemA(String itemA) {
		this.itemA = itemA;
	}

	public String getItemB() {
		return itemB;
	}

	public void setItemB(String itemB) {
		this.itemB = itemB;
	}

	public String getItemC() {
		return itemC;
	}

	public void setItemC(String itemC) {
		this.itemC = itemC;
	}

	public String getItemD() {
		return itemD;
	}

	public void setItemD(String itemD) {
		this.itemD = itemD;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getOccurTime() {
		return occurTime;
	}

	public void setOccurTime(String occurTime) {
		this.occurTime = occurTime;
	}

}
