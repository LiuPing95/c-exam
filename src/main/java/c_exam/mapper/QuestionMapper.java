package c_exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import c_exam.pojo.dao.QuestionInfo;

/**
 * 题目数据接口
 * 
 * @author LiuPing
 * @since 2017年3月18日
 */
public interface QuestionMapper {

	void addQuestion(@Param("obj") QuestionInfo obj);

	List<QuestionInfo> getQuestionInfo(@Param("id") Integer id);

}