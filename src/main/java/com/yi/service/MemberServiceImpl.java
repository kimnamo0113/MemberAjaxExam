package com.yi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yi.domain.Member;
import com.yi.persistence.MemberDao;

@Repository
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDao dao;

	@Override
	public void insert(Member member) {
		dao.insert(member);
	}

	@Override
	public List<Member> list() {
		return dao.list();
	}
	
	
}
