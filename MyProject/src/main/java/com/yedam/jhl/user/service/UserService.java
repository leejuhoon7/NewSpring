package com.yedam.jhl.user.service;

import java.util.List;

public interface UserService {
	
	// 전체 조회
	public List<UserVO> selectUserList();
	
	// 단건 조회
	public UserVO selectUserInfo(UserVO uservo);
	
	// 등록
	public int insertUser(UserVO userVO);
	
	// 수정
	public int updateUser(UserVO uservo);
	
	// 삭제
	public int deleteUser(UserVO uservo);
	
	
	
}
