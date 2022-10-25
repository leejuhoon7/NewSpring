package com.yedam.jhl.book.mapper;

import java.util.List;

import com.yedam.jhl.book.service.BookVO;

public interface BookMapper {
	
	// 전체조회
	public List<BookVO> getBookList();
	
	// 번호 조회
	public BookVO getBookNO();
	
	//등록
	public int insertBook(BookVO bookVO);
	
	//대여현황
	public BookVO getRentalInfo();
}
