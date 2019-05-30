package com.cafe24.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jblog.vo.BlogVo;

@Repository
public class BlogDao {
	
	@Autowired
	SqlSession sqlSession;
	
	public boolean insert(BlogVo vo) {
		int count = sqlSession.insert("blog.insert",vo);
		return count == 1;
	}

	public boolean update(BlogVo vo) {
		int count = sqlSession.update("blog.update",vo);
		return count == 1;
	}

	public BlogVo get(String blogId) {
		return sqlSession.selectOne("blog.get", blogId);
	}
}
