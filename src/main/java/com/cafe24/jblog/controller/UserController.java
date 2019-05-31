package com.cafe24.jblog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.jblog.service.UserService;
import com.cafe24.jblog.vo.JSONResult;
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
	public String join(@ModelAttribute @Valid UserVo userVo, BindingResult result, Model model) {
		if( result.hasErrors() ) {
				List<ObjectError> list = result.getAllErrors();
				for(ObjectError error : list) {
					System.out.println(error);
				}
				model.addAllAttributes(result.getModel());	
				return "user/join";
			}
			userService.register(userVo);
			return "redirect:/user/joinsuccess";
		}
	
	@GetMapping("joinsuccess")
	public String joinSuccess() {
		System.out.println("joinsuccess get 호출");
		return "user/joinsuccess";
	}
	@ResponseBody
	@RequestMapping("/checkId")
	public JSONResult checkId(@RequestParam(value="id", required=true, defaultValue="") String id) {
		Boolean exist = userService.existId(id);
		return JSONResult.success(exist);
	}
}
