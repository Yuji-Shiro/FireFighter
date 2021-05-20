package com.example.demo.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Service.MService;


@Controller
public class MController {
	@Autowired
	private MService service;

	@GetMapping("/list")
	public String getMlist(Model model) {
		model.addAttribute("member", service.getList());
		return "list";
	}
}
