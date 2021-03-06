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

	QuestionInfo getQuestionInfoById(@Param("id") Integer id);

	List<QuestionInfo> getQuestionByIds(@Param("ids") List<Integer> ids);

	List<Integer> getQuestionIds(@Param("type") String type);

	// 根据题型分组
	List<QuestionInfo> getQuestionByPage(@Param("start") int start, @Param("end") int end, @Param("type") String type,
			@Param("content") String content);

	int getTotal(@Param("type") String type, @Param("content") String content);

	List<String> getTypes();

	void del(@Param("id") Integer id);

	void update(@Param("obj") QuestionInfo obj);

}