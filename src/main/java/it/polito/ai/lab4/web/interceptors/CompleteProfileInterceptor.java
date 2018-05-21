package it.polito.ai.lab4.web.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import it.polito.ai.lab4.business.services.authentication.CurrentUserService;
import it.polito.ai.lab4.repo.entities.User;

@Component
public class CompleteProfileInterceptor implements HandlerInterceptor {
	@Autowired
	private CurrentUserService currentUserService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		User user = currentUserService.getCurrentUser();
		if (user != null) {
			if (user.getStatus().getValue().equals("INCOMPLETE")) {
				response.sendRedirect("/updateProfile");
				return false;
			}
			else {
				return true;
			}
		}
		
		return true;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}
}
