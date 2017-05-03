package c_exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import c_exam.pojo.dao.ExamQuestionType;

/**
 * 题型数据接口
 * 
 * @author LiuPing
 * @since 2017年3月18日
 */
public interface ExamQuestionTypeMapper {

	void addExamQuestionType(@Param("obj") ExamQuestionType obj);

	ExamQuestionType getExamQuestionTypeById(@Param("id") Integer id);
	
	List<ExamQuestionType> getExamQuestionTypes(@Param("start") Integer start, @Param("end") Integer end);

	/**
	 * 
	 * 根据考试编号获取考试题型
	 * 
	 * @param examId
	 * @return
	 * */
	List<ExamQuestionType> getExamQuestionTypeByExamId(@Param("examId") Integer examId);

	List<ExamQuestionType> getAll();
}