package com.ctrl;

import com.database.Actions;
import com.database.Database;
import com.entities.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeCtrl {
	ServletContext sc;

	@Autowired
	Actions ac;

	@RequestMapping("/home")
	public String home(Model m) {
		ArrayList<Todo> all_data=ac.getTodos();

		String str = "home";
		m.addAttribute("page", str);
		m.addAttribute("all_data",all_data);
		return "home";
	}

	@RequestMapping("/add")
	public String addTodo(Model m) {
		Todo todo=new Todo();
		m.addAttribute("page", "add");
		m.addAttribute("todo",todo);
		return "home";
	}

	@RequestMapping(value="/saveTodo",method = RequestMethod.POST)
	public String saveTodo(@ModelAttribute("todo") Todo todo, Model m){
//		ArrayList<Todo> list = (ArrayList<Todo>)sc.getAttribute("list");
		if(ac.insertData(todo)){
			m.addAttribute("msg","item added successfully");
		}else{
			m.addAttribute("msg","some problem occurred");
		}
//		list.add(todo);
		return "home";
	}
}
