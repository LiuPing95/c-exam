package c_exam.util;

/**
 * @author LiuPing
 * @since 2017年4月16日
 */
public final class UserConstant {
	
	private UserConstant() throws Exception {
		throw new Exception("该类不能被实例化");
	}
	
	/**
	 * 当前登录用户：可用枚举代替？（已经包含了角色信息）
	 */
	public final static String CUR_USER = "currentUser";
	
	/**
	 * 当前用户拥有的权限
	 */
	public final static String CUR_PERMISSION = "currentPermission";
}
