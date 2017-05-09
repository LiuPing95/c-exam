package c_exam.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c_exam.mapper.ExamQuestionTypeMapper;
import c_exam.mapper.QuestionMapper;
import c_exam.pojo.dao.ExamQuestionType;
import c_exam.pojo.dao.QuestionInfo;

/**
 * 生成考题编号
 * 
 * @author LiuPing
 * @since 2017年4月14日
 */
@Service
public class GenerateExamService {

	@Autowired
	private ExamQuestionTypeMapper examQuestionTypeMapper;

	@Autowired
	private QuestionMapper questionMapper;
	
	@Deprecated
	public Map<String, List<QuestionInfo>> generateQuestionIds() {
		// 获取到这次考试的题型
		List<ExamQuestionType> obj = examQuestionTypeMapper.getAll();
		Map<String, List<QuestionInfo>> map = new HashMap<String, List<QuestionInfo>>();
		Random r = new Random();
		for (ExamQuestionType dao : obj) {
			// 获取这个题型所有的编号（在数据库中的id）TODO：这里面的题型不应该为null
			List<Integer> ids = questionMapper.getQuestionIds(dao.getType());
			int size = ids.size();
			if(size <= 0) {
				continue;
			}
			Integer[] idArr = ids.toArray(new Integer[size]);
			List<Integer> idSelect = new ArrayList<Integer>();
			// 从该题型中抽取题目的id
			for (int i = 0; i < dao.getSum(); i++) {
				if (size <= 0) {
					break;
				}
				int index = r.nextInt(size);
				// 把选中的题目的id添加到list中
				idSelect.add(idArr[index]);
				// 把最后一个替换到已经选中的位置
				idArr[index] = idArr[size - 1];
				// 把最后一个挤出去
				size--;
			}
			// 根据题目的id查出具体的题目
			List<QuestionInfo> questions = questionMapper.getQuestionByIds(idSelect);
			map.put(dao.getType(), questions);
		}
		return map;
	}
	
	public List<QuestionInfo> generateQuestions() {
		// 获取到这次考试的题型
		List<ExamQuestionType> obj = examQuestionTypeMapper.getAll();
		List<QuestionInfo> list = new ArrayList<QuestionInfo>();
		Random r = new Random();
		for (ExamQuestionType dao : obj) {
			// 获取这个题型所有的编号（在数据库中的id）TODO：这里面的题型不应该为null
			List<Integer> ids = questionMapper.getQuestionIds(dao.getType());
			int size = ids.size();
			if(size <= 0) {
				continue;
			}
			Integer[] idArr = ids.toArray(new Integer[size]);
			List<Integer> idSelect = new ArrayList<Integer>();
			// 从该题型中抽取题目的id
			for (int i = 0; i < dao.getSum(); i++) {
				if (size <= 0) {
					break;
				}
				int index = r.nextInt(size);
				// 把选中的题目的id添加到list中
				idSelect.add(idArr[index]);
				// 把最后一个替换到已经选中的位置
				idArr[index] = idArr[size - 1];
				// 把最后一个挤出去
				size--;
			}
			// 根据题目的id查出具体的题目
			list.addAll(questionMapper.getQuestionByIds(idSelect));
//			List<QuestionInfo> questions = questionMapper.getQuestionByIds(idSelect);
		}
		return list;
	}
	
}
