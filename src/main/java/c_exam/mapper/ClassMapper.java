package c_exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import c_exam.pojo.dao.ClassInfo;

/**
 * 班级数据接口
 * 
 * @author LiuPing
 * @since 2017年3月18日
 */
public interface ClassMapper {

	void addClass(@Param("obj") ClassInfo obj);

	/**
	 * 根据classId精确查找班级信息
	 * 
	 * @param id 班级id
	 * @return 符合条件的班级信息
	 */
	ClassInfo getClassInfoById(@Param("id") Integer id);

	/**
	 * 分页查询数据，TODO：后面还要支持多条件分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return 符合条件的班级信息
	 */
	List<ClassInfo> getClassInfo(@Param("start") Integer start, @Param("end") Integer end);
}