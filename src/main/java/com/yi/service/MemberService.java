package com.yi.service;

import java.util.List;

import com.yi.domain.Member;

public interface MemberService {
	public void insert(Member member);

	public List<Member> list();

	
}
