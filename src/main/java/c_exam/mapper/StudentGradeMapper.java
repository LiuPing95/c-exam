package c_exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import c_exam.pojo.dao.StudentGradeInfo;
import c_exam.pojo.dto.StudentGradeDto;

/**
 * 题目数据接口
 * 
 * @author LiuPing
 * @since 2017年3月18日
 */
public interface StudentGradeMapper {

	void addStudentGrade(@Param("obj") StudentGradeInfo obj);

	List<StudentGradeDto> getStuGradeList();

	StudentGradeDto getGrade(@Param("stuId") int stuId, @Param("examId") int examId);

	void updateGrade(@Param("stuId") Integer stuId, @Param("score") Integer score);

}