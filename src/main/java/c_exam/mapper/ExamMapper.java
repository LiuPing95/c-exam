package c_exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import c_exam.pojo.dao.ExamInfo;

/**
 * 考试信息接口
 * 
 * @author LiuPing
 * @since 2017年3月18日
 */
public interface ExamMapper {

	void addExam(@Param("obj") ExamInfo obj);

	List<ExamInfo> getExamInfo(@Param("id") Integer id);

}