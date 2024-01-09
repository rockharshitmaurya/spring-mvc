package com.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeCtrl {

	@RequestMapping("/home")
	public String home(Model m) {
		String str = "home";
		m.addAttribute("page", str);
		return "home";
	}

	@RequestMapping("/add")
	public String addTodo(Model m) {
		m.addAttribute("page", "add");
		return "home";
	}
}
