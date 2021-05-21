package com.example.demo.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.MService;
import com.example.demo.domain.Member;


@Controller
@RequestMapping("/members")
public class MController {
	@Autowired
	private MService service;
	
/*top画面表示*/
	@GetMapping("")
	public String top(Model model,@ModelAttribute Member m) {
		model.addAttribute("members", service.getList());
		return "members/top";
	}
/*1件取得*/
	 @GetMapping("details/id={id}")
     public String details(@PathVariable("id") String id, Model model) {
		 model.addAttribute("members", service.getOne(id));
	        return "members/details"; 
	 }
/*新規登録*/
	@GetMapping("/new")
	public String entryMember(Model model, @ModelAttribute Member m) {
		model.addAttribute("members", m);
		return "members/new";
	}
/*新規登録処理*/
	@PostMapping("/new")
	public String create(@Validated @ModelAttribute Member m, BindingResult result) {
		if (result.hasErrors()) {
			return "members/new";
		}
		service.insertOne(m);
		return "redirect:/members";
	}
/*詳細変更*/
	@GetMapping("change/id={id}")
	public String change(@PathVariable("id") String id, Model model) {
        model.addAttribute("members", service.getOne(id));
        return "members/change";
    }
/*詳細変更処理*/ //
	@PostMapping("change/id={id}")
	public String update(@ModelAttribute Member m, Model model) {
		service.updateOne(m.getId(), m.getName(), m.getRole(), m.getAge());
		return "redirect:/members";
	}
/*削除*/
	@PostMapping("delete/id={id}")
    public String delete(@PathVariable String id, @ModelAttribute Member m) {
        service.deleteOne(m);
        return "redirect:/members";
	}
}