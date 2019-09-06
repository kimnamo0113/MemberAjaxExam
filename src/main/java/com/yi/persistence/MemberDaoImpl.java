package com.yi.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yi.domain.Member;
@Repository
public class MemberDaoImpl implements MemberDao {
	private static final String namespace = "com.yi.mapper.MemberMapper";
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public void insert(Member member) {
		sqlSession.insert(namespace+".insert",member);
	}

	@Override
	public List<Member> list() {
		return sqlSession.selectList(namespace+".list");
	}
	
	
}
