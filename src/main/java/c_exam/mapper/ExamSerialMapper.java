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

	List<ExamSerialInfo> getExamSerialInfo(@Param("id") Integer id);

}