package c_exam.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import c_exam.pojo.dao.QuestionInfo;
import c_exam.pojo.dao.QuestionType;
import c_exam.service.QuestionService;
import c_exam.util.ExcelUtil;
import c_exam.util.Page;

/**
 * @author LiuPing
 * @since 2017年3月28日
 */
@Controller
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@RequestMapping("toEdit")
	public ModelAndView toAdd(String action, Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		if ("add".equals(action)) {
			map.put("action", "add");
			List<String> types = new ArrayList<String>();
			types.add(QuestionType.BLANK.getValue());
			types.add(QuestionType.CHOOSE.getValue());
			types.add(QuestionType.PROGRESS.getValue());
			map.put("types", types);
		}
		if ("edit".equals(action)) {
			map.put("action", "edit");
		}
		map.put("content", "questionEdit");
		return new ModelAndView("index").addAllObjects(map);
	}

	@RequestMapping("add")
	public String add(QuestionInfo obj) {
		questionService.add(obj);
		return "redirect:/question/list";
	}

	@RequestMapping("edit")
	public String edit(QuestionInfo obj) {
		return "redirect:/question/list";
	}
	
	@RequestMapping("del")
	public String del(Integer id) {
		questionService.del(id);
		return "redirect:/question/list";
	}

	@RequestMapping("list")
	public ModelAndView list(Page<QuestionInfo> page, String type, String content) {
		if (page == null) {
			page = new Page<QuestionInfo>();
		}
		if (type != null) {
			type = "".equals(type.trim()) ? null : type;
		}
		if (content != null) {
			content = "".equals(content.trim()) ? null : content;
		}
		page.setData(questionService.getQuestionByPage(page.getPageNum(), page.getPageSize(), type, content));
		int total = questionService.getTotal(type, content);
		int totalPage = total / page.getPageSize();
		page.setTotal(total);
		page.setTotalPage(total % page.getPageSize() > 0 ? totalPage + 1 : totalPage);
		List<String> types = new ArrayList<String>();
		types.add(QuestionType.BLANK.getValue());
		types.add(QuestionType.CHOOSE.getValue());
		types.add(QuestionType.PROGRESS.getValue());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("types", types);
		map.put("content", "question");
		map.put("page", page);
		return new ModelAndView("index").addAllObjects(map);
	}

	@RequestMapping("import")
	public String importTemplate(@RequestParam("file") CommonsMultipartFile file, RedirectAttributes attr) {
		try {
			String[][] data = ExcelUtil.getData(file.getInputStream(), 0);
			if (data == null || data.length == 0) {
				attr.addFlashAttribute("msg", "没有数据");
			}
			else if (data[0] == null || data[0].length < 5 || !"用户ID".equals(data[0][0]) || !"道具类型（星豆；礼物道具）".equals(data[0][1])
					|| !"道具ID".equals(data[0][2]) || !"道具数量".equals(data[0][3]) || !"原因(必填，标明活动名或内部发放)".equals(data[0][4])) {
				attr.addFlashAttribute("msg", "请按照下载模版导入，并且不要删除第一行标题栏");
			}
			else {
				attr.addFlashAttribute("msg", "成功导入" + (data.length - 1) + "条");
				List<QuestionInfo> list = new ArrayList<QuestionInfo>();
				for (int i = 1; i < data.length; i++) {
					QuestionInfo info = new QuestionInfo();
					if (data[i] == null || data[i].length < 5 || StringUtils.isBlank(data[i][0])) {
						attr.addFlashAttribute("msg", "第" + (i + 1) + "行，用户ID为空,导入失败");
						break;
					}
					else if (data[i] == null || data[i].length < 5 || StringUtils.isBlank(data[i][3])) {
						attr.addFlashAttribute("msg", "第" + (i + 1) + "行，道具数量为空,导入失败");
						break;
					}
					else if (data[i] == null || data[i].length < 5 || StringUtils.isBlank(data[i][4])) {
						attr.addFlashAttribute("msg", "第" + (i + 1) + "行，原因为空,导入失败");
						break;
					}
					else {
						info.setAnswer("");
						list.add(info);
					}
				}
				if (list.size() == data.length - 1) {

				}
			}
		} catch (Exception e) {

		}
		return "redirect:/question/list";
	}
}
