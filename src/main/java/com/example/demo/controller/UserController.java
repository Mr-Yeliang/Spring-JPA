package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.example.demo.domain.User;
import com.example.demo.service.EntityService;

@Controller
public class UserController {

	@Autowired
	EntityService us;

	@RequestMapping(value = "/index")
	public String sel(Model model) {
		List<User> list = new ArrayList<>();
		list = us.findAll();
		// 发送数据
		model.addAttribute("list", list);
		return "indexpage";
	}
}
