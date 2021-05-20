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

	public List<Member> getList() {
		return mapper.find();
	}

}
