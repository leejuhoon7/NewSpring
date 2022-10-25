package com.yedam.jhl.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.jhl.user.mapper.UserMapper;
import com.yedam.jhl.user.service.UserService;
import com.yedam.jhl.user.service.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	
	@Override
	public List<UserVO> selectUserList() {
		return userMapper.getUserList();
	}

	@Override
	public UserVO selectUserInfo(UserVO uservo) {
		return userMapper.getUserInfo(uservo);
	}

	@Override
	public int insertUser(UserVO userVO) {
		return 0;
	}

	@Override
	public int updateUser(UserVO uservo) {
		return 0;
	}

	@Override
	public int deleteUser(UserVO uservo) {
		return 0;
	}

	

}
