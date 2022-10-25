package com.yedam.jhl.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.jhl.book.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService service;
	
	@GetMapping("booklist")
		public String selectBookList(Model model) {
			model.addAttribute("list", service.selectBookList());
			return "book/list";
			
	}
}
