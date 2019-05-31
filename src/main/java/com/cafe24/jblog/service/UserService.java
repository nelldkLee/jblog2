package com.cafe24.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.jblog.repository.BlogDao;
import com.cafe24.jblog.repository.CategoryDao;
import com.cafe24.jblog.repository.UserDao;
import com.cafe24.jblog.vo.BlogVo;
import com.cafe24.jblog.vo.CategoryVo;
import com.cafe24.jblog.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private BlogDao blogDao;
	@Autowired
	private CategoryDao categoryDao;
	
	public void register(UserVo vo) {
		userDao.insert(vo);
		blogDao.insert(new BlogVo().setBlogId(vo.getId()).setName(vo.getName()));
		categoryDao.insert(new CategoryVo().setBlogId(vo.getId()).setTitle("미분류").setDescription("미분류 카테고리입니다."));
	}

	public UserVo getUser(UserVo vo) {
		return userDao.get(vo);
	}

	public Boolean existId(String id) {
		return userDao.getUserExist(id);
	}

}
