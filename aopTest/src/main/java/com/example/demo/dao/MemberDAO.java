package com.example.demo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	public int insert() {
		System.out.println("회원을 등록하였습니다.");
		return 1;
	}
	
	public int update() {
		System.out.println("회원을 수정하였습니다.");
		return 1;
	}
	
}
