package c_exam.service;

import java.util.List;

import c_exam.pojo.dao.StudentGradeInfo;
import c_exam.pojo.dto.StudentGradeDto;

/**
 * @author LiuPing
 * @since 2017年5月10日
 */
public interface StuGradeService {

	List<StudentGradeDto> getStuGradeList();

	StudentGradeDto getReport(int stuId, int examId);

	void addStuGrade(StudentGradeInfo grade);

	void updateGrade(Integer stuId, Integer score);
	
}
