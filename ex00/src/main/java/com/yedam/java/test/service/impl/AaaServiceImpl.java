package com.yedam.java.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.java.test.mapper.AaaMapper;
import com.yedam.java.test.service.AaaService;

@Service
public class AaaServiceImpl implements AaaService{

	@Autowired
	AaaMapper mapper;

	@Transactional
	@Override
	public void insert() {
		mapper.insert("101");
		mapper.insert("값");
	}

	@Override
	public void test() {
		this.insert();
	}
	
	
	
}
