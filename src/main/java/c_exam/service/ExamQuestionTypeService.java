package c_exam.service;

import java.util.List;

import c_exam.pojo.dao.ExamQuestionType;

/**
 * @author LiuPing
 * @since 2017年5月1日
 */
public interface ExamQuestionTypeService {

	List<ExamQuestionType> getAll();

	void addType(ExamQuestionType obj);

	void del(Integer id);
}
