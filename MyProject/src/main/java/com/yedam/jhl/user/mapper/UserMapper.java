package com.yedam.jhl.user.mapper;

import java.util.List;

import com.yedam.jhl.user.service.UserVO;

public interface UserMapper {
	
	// 전체 조회
	public List<UserVO> getUserList();
	
	// 단건 조회
	public UserVO getUserInfo(UserVO uservo);
	
	// 등록
	public UserVO getInsertUser(UserVO uservo);
	
	// 수정
	public UserVO getUpdateUser(UserVO uservo);
	
	//삭제
	public UserVO getDeleteUser(UserVO uservo);
	
	
}
