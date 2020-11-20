package com.core.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.core.pojo.User;
import com.core.service.UserService;
import com.core.utils.MD5;

@Controller
public class UserController {
   
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public String login(HttpServletRequest request,String usercode,String password,Model model,HttpSession session)
	{
		
		String code=request.getParameter("checkCode");
		String check_code=(String)session.getAttribute("code");
		
//		System.out.println(code+"---"+check_code);
		if(code.equalsIgnoreCase(check_code)) //不分大小写
		{
			password = MD5.getMD5_50(password);
			User user = userService.findUser(usercode, password);
			
			if(user!=null)
			{
				session.setAttribute("userName", user.getUser_name());
				session.setAttribute("userId", user.getUser_id());
				return "/WEB-INF/jsp/index";
			}
			else {
				model.addAttribute("msg", "<script type='text/javascript'>alert('账号或密码错误!!!');</script>");
				return "/WEB-INF/jsp/login";
			}
		}
	
		model.addAttribute("code", "<script type='text/javascript'>alert('验证码错误!!!');</script>");
		return "/WEB-INF/jsp/login";
		
		
		
	}
	/*
	 * 退出登录
	 */
	@GetMapping("/out")
	public String out(HttpSession session)
	{
		//清除session
		session.invalidate();
		
		return "/WEB-INF/jsp/login";
		
	}
	
}
