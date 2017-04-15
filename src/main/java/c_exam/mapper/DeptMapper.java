package c_exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import c_exam.pojo.dao.DeptInfo;

/**
 * 系别数据接口
 * 
 * @author LiuPing
 * @since 2017年3月18日
 */
public interface DeptMapper {

	void addDept(@Param("obj") DeptInfo obj);
	
	DeptInfo getDeptById(@Param("id") Integer id);

	List<DeptInfo> getDeptInfo(@Param("start") Integer start, @Param("end") Integer end);

}