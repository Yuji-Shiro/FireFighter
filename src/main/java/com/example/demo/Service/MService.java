package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MMapper;

@Service
public class MService {
	@Autowired
	MMapper mapper;
/*1件取得*/
	public Member getOne(String id) {
		return mapper.findOne(id);
	}
/*全件取得*/
	public List<Member> getList() {
		return mapper.find();
	}
/*新規登録*/
	public void insertOne(Member m) {
		mapper.insertOne(m);
	}
/*詳細変更*/
	public void updateOne(String id, String name, String role, int age) {
		mapper.updateOne(id, name, role, age);
	}
/*削除*/
	public void deleteOne(Member m) {
		mapper.deleteOne(m);
	}
}