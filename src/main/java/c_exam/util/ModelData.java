package c_exam.util;

import java.util.Map;

/**
 * @author LiuPing
 * @since 2017年4月20日
 */
public final class ModelData {
	
	private ModelData() throws Exception {
		throw new Exception("本类不允许实例化");
	}
	
	private static Map<String, Object> dataMap = null;

	public static Map<String, Object> getDataMap() {
		return dataMap;
	}

	public static void setDataMap(Map<String, Object> dataMap) {
		ModelData.dataMap = dataMap;
	}
}
