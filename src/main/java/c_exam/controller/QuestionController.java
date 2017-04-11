package c_exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author LiuPing
 * @since 2017年3月28日
 */
@Controller
@RequestMapping("/question")
public class QuestionController {

	@RequestMapping("list")
	public ModelAndView list() {
		return null;
	}
}
