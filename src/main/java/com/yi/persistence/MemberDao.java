package com.yi.persistence;

import java.util.List;

import com.yi.domain.Member;

public interface MemberDao {
	public void insert(Member member);

	public List<Member> list();
}
