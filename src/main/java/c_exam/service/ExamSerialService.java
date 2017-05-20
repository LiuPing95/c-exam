package c_exam.service;

import java.util.List;

import c_exam.pojo.dao.ExamSerialInfo;

/**
 * @author LiuPing
 * @since 2017年5月3日
 */
public interface ExamSerialService {

	List<ExamSerialInfo> getAll();

	ExamSerialInfo getById(Integer id);

	void add(ExamSerialInfo obj);

	void del(Integer id);

	void forUse(Integer id);

	ExamSerialInfo getCur();
}
