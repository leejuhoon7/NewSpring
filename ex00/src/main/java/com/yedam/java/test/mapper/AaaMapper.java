package com.yedam.java.test.mapper;

import org.apache.ibatis.annotations.Insert;

public interface AaaMapper {
	
	@Insert("insert into aaa values (#{value})")
	public void insert(String value);
	
}
