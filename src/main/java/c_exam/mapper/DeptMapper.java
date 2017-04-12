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

	List<DeptInfo> getDeptInfo(@Param("id") Integer id);

}