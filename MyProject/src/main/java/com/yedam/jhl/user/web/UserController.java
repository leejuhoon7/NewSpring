package com.yedam.jhl.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.jhl.user.service.UserService;
import com.yedam.jhl.user.service.UserVO;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	// 전체조회
	@RequestMapping("userList")
	public String getUserList(Model model) {
		model.addAttribute("userList", userService.selectUserList());
		
		return "user/userList";
	}
	
	// 등록 폼
	
	@GetMapping("userInsert")
	public String userInsertForm() {
		return "user/userInsert";
	}
	
	@PostMapping("userInsert")
	public String getInsertUser(UserVO userVO, RedirectAttributes ratt ) {
		int result = userService.insertUser(userVO);
		
		if(result == 1) {
			ratt.addAttribute("msg", "정상적으로 등록되었습니다.");
		} else {
			ratt.addAttribute("msg", "유저등록 실패");
		}
		
		return "redirect:userList";
	}
	
	
}
