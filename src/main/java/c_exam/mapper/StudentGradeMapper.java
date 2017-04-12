package c_exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import c_exam.pojo.dao.StudentGradeInfo;

/**
 * 题目数据接口
 * 
 * @author LiuPing
 * @since 2017年3月18日
 */
public interface StudentGradeMapper {

	void addStudentGrade(@Param("obj") StudentGradeInfo obj);

	List<StudentGradeInfo> getStudentGradeInfo(@Param("id") Integer id);

}