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

	List<ClassInfo> getClassInfo(@Param("id") Integer id);

}