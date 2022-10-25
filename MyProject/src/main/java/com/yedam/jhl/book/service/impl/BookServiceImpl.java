package com.yedam.jhl.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.jhl.book.mapper.BookMapper;
import com.yedam.jhl.book.service.BookService;
import com.yedam.jhl.book.service.BookVO;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookMapper mapper;

	@Override
	public List<BookVO> selectBookList() {
		return mapper.getBookList();
	}

	@Override
	public BookVO selectBookNO() {
		return mapper.getBookNO();
	}

	@Override
	public int insertBookInfo(BookVO bookVO) {
		return mapper.insertBook(bookVO);
	}

}
