package c_exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import c_exam.pojo.dao.ExamQuestionType;

/**
 * 班级数据接口
 * 
 * @author LiuPing
 * @since 2017年3月18日
 */
public interface ExamQuestionTypeMapper {

	void addExamQuestionType(@Param("obj") ExamQuestionType obj);

	List<ExamQuestionType> getExamQuestionType(@Param("id") Integer id);

}