package c_exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import c_exam.pojo.dao.StudentAnswerInfo;

/**
 * 学生答题记录接口
 * 
 * @author LiuPing
 * @since 2017年3月18日
 */
public interface StudentAnswerMapper {

	void addStudentAnswer(@Param("obj") StudentAnswerInfo obj);

	List<StudentAnswerInfo> getStudentAnswerInfo(@Param("id") Integer id);

}