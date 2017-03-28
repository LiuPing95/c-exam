package c_exam.bean.question;

/**
 * 题型
 * 
 * @author LiuPing
 * @since 2017年3月19日
 */
public enum QuestionType {

	CHOOSE("CHOOSE"),
	
	BLANK("BLANK"),
	
	PROGRESS("PROGRESS");
	
	private String value;
	
	private QuestionType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
}
