package c_exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import c_exam.pojo.dao.ExamSerialInfo;

/**
 * 考试序号接口
 * 
 * @author LiuPing
 * @since 2017年3月18日
 */
public interface ExamSerialMapper {

	void addExamSerial(@Param("obj") ExamSerialInfo obj);

	ExamSerialInfo getExamSerialInfoById(@Param("id") Integer id);
	
	List<ExamSerialInfo> getExamSerialInfo(@Param("start") Integer start, @Param("end") Integer end);

	List<ExamSerialInfo> getAll();

	void del(@Param("id") Integer id);

	void use(@Param("id") Integer id);

	void cancel(@Param("id") Integer id);

	ExamSerialInfo getCur();

}