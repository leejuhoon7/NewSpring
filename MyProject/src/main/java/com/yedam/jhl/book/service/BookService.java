package com.yedam.jhl.book.service;

import java.util.List;

public interface BookService {
	
	//도서목록
	public List<BookVO> selectBookList();
	//번호조회
	public BookVO selectBookNO();
	//등록
	public int insertBookInfo(BookVO bookVO);
}
