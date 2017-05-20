package c_exam.util;

/**
 * @author LiuPing
 * @since 2017年4月16日
 */
public final class AppConstant {
	
	private AppConstant() throws Exception {
		throw new Exception("该类不能被实例化");
	}
	
	/**
	 * 当前用于考试的题目
	 */
	public final static String CUR_QUESTION = "curQuestion";
	
	/**
	 * 当前使用的考试场次
	 */
	public final static String CUR_EXAM = "curExam";
	
	/**
	 * 当前登录用户：可用枚举代替？（已经包含了角色信息）
	 */
	public final static String CUR_USER = "currentUser";
	
	/**
	 * 当前用户拥有的权限
	 */
	public final static String CUR_PERMISSION = "currentPermission";
}
