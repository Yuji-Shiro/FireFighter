package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.domain.Member;


@Mapper
public interface MMapper {
/*1件取得*/
	public Member findOne(String id);
/*全件取得*/
	public List<Member> find();
/*新規登録*/
	public void insertOne(Member m);
/*詳細変更*/
	public void updateOne(@Param("id")String id,@Param("name")String name, @Param("role")String role, @Param("age")int age);
/*削除*/
	public void deleteOne(Member m);
}
