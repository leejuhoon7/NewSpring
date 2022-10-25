package com.yedam.jhl.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.jhl.book.service.BookService;
import com.yedam.jhl.book.service.BookVO;

@Controller
public class BookController {
	
	@Autowired
	BookService service;
	//도서목록조회
	@GetMapping("booklist")
		public String selectBookList(Model model) {
			model.addAttribute("list", service.selectBookList());
			return "book/booklist";
	}
	
	//도서등록 페이지 이동 + 현재 등록될, 예상되는 번호
	@GetMapping("bookinsert")
	public String insertBookForm(Model model) {
		model.addAttribute("info", service.selectBookNO());
			
		return "book/insertbook";
	}
	
	@PostMapping("bookinsert")
	public String insertBook(BookVO bookVO ) {
		service.insertBookInfo(bookVO);
		return "redirect:booklist";
	}
	
}
