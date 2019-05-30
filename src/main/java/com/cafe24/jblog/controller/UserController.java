package com.cafe24.jblog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.jblog.service.UserService;
import com.cafe24.jblog.vo.UserVo;

@Controller
@RequestMapping("/user/")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("login")
	public String login() {
		System.out.println("login get 호출");
		return "user/login";
	}
	
	@GetMapping("join")
	public String join() {
		System.out.println("join get 호출");
		return "user/join";
	}

	@PostMapping("join")
	public String join(UserVo vo) {
		System.out.println("join post 호출");
		userService.register(vo);
		return "redirect:/user/joinsuccess";
	}
	
	@GetMapping("joinsuccess")
	public String joinSuccess() {
		System.out.println("joinsuccess get 호출");
		return "user/joinsuccess";
	}
}
