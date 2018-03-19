package com.talelife.myproject.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/")
    public String home() {
        return "this is home!";
    }

	@RequestMapping("/login")
    public String login(HttpServletRequest request) {
		request.getSession().setAttribute("loginUserName", request.getParameter("name"));
        return "login success";
    }
	
	@RequestMapping("/get_login_user")
    public String getLoginUser(HttpServletRequest request) {
		String userName = (String)request.getSession().getAttribute("loginUserName");
        return userName;
    }
}
