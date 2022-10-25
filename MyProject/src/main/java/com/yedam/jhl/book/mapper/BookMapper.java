package com.yedam.jhl.book.mapper;

import java.util.List;

import com.yedam.jhl.book.service.BookVO;

public interface BookMapper {
	
	// 전체조회
	public List<BookVO> getBookList();
	
	
	
}
