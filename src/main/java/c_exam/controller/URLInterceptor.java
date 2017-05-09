package c_exam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import c_exam.pojo.dto.UserDto;
import c_exam.util.AppConstant;

/**
 * @author LiuPing
 * @since 2017年4月19日
 */
public class URLInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (!request.getRequestURI().contains("login")) {
			UserDto dto = (UserDto) request.getSession().getAttribute(AppConstant.CUR_USER);
			if(dto == null) {
				response.sendRedirect(request.getContextPath() + "/login");
				// 还必须有个返回值
				return false;
			}
		}
		return true;
	}

}
