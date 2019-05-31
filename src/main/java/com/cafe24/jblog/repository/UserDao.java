package com.cafe24.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jblog.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;

	public boolean insert(UserVo vo) {
		int count = sqlSession.insert("user.insert",vo);
		return count == 1;
	}

	public UserVo get(UserVo vo) {
		return sqlSession.selectOne("user.getUserByPassword", vo);
	}
	public boolean getUserExist(String id) {
		UserVo vo = sqlSession.selectOne("user.getUserExist",id);
		return vo != null? true : false;
	}
	
}
