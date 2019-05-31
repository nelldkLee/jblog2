package com.cafe24.jblog.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.jblog.repository.BlogDao;
import com.cafe24.jblog.repository.CategoryDao;
import com.cafe24.jblog.repository.PostDao;
import com.cafe24.jblog.vo.BlogVo;
import com.cafe24.jblog.vo.CategoryVo;
import com.cafe24.jblog.vo.PostVo;

@Service
public class BlogService {

	@Autowired
	private BlogDao blogDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private PostDao postDao; 

	public Map<String,Object> getMainList(String blogId, Integer categoryNo) {
		Map<String, Object> map = new HashMap<>();
		List<CategoryVo> categoryList = categoryDao.getList(blogId);
		BlogVo blogVo = blogDao.get(blogId);
		List<PostVo> postList = postDao.getList(categoryNo);
		map.put("postList", postList);
		map.put("categoryList", categoryList);
		map.put("blogVo", blogVo);
		return map;
	}

	public void modify(BlogVo vo) {
		blogDao.update(vo);
	}

	public BlogVo getBlog(String blogId) {
		return blogDao.get(blogId);
	}
	public boolean registerPost(PostVo postVo) {
		return postDao.insert(postVo);
	}
}
