package com.cafe24.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.jblog.repository.CategoryDao;
import com.cafe24.jblog.vo.CategoryVo;

@Service
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	public boolean register(CategoryVo categoryVo) {
		return categoryDao.insert(categoryVo);
	}
	public List<CategoryVo> getList(String blogId) {
		return categoryDao.getList(blogId);
	}
	public boolean delete(Integer categoryNo) {
		int count = categoryDao.delete(categoryNo);
		return count == 1;
	}

}
