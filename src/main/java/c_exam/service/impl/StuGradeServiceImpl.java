package c_exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c_exam.mapper.StudentGradeMapper;
import c_exam.pojo.dto.StudentGradeDto;
import c_exam.service.StuGradeService;

/**
 * @author LiuPing
 * @since 2017年5月10日
 */
@Service
public class StuGradeServiceImpl implements StuGradeService {

	@Autowired
	private StudentGradeMapper gradeMapper;
	
	public List<StudentGradeDto> getStuGradeList() {
		return gradeMapper.getStuGradeList();
	}

	public StudentGradeDto getReport(int stuId, int examId) {
		return gradeMapper.getGrade(stuId, examId);
	}

}
