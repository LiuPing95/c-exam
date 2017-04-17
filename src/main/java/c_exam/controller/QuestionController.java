package c_exam.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import c_exam.pojo.dao.QuestionInfo;
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
	
	@RequestMapping("list")
	public ModelAndView list() {
		Page<QuestionInfo> page = new Page<QuestionInfo>();
		page.setData(questionService.getQuestionByPage(page.getPageNum(), page.getPageSize()));
		return new ModelAndView("index").addObject("content", "question").addObject("page", page);
	}
	
	@RequestMapping("import")
	public String importTemplate(@RequestParam("file") CommonsMultipartFile file, RedirectAttributes attr) {
		attr.addAttribute("action", "search");
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
					questionService.batchAdd(list);
				}
			}
		} catch (Exception e) {

		}
		return "redirect:/bus/gameCoinSend/list";
	}
}
