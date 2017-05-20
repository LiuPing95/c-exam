package c_exam.service;

import java.util.List;

import c_exam.pojo.dao.ExamInfo;

/**
 * @author LiuPing
 * @since 2017年5月8日
 */
public interface ExamInfoService {
	
	void add(ExamInfo obj);

	List<Integer> getQuestionIdsByExamId(int id);

	void clear(int id);
}
