package com.akhm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.akhm.dto.User;
import com.akhm.dto.UsersDTO;
import com.akhm.service.ResultService;
import com.akhm.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private ResultService resultService;
	@GetMapping("/users")
	public String showUsers(HttpServletRequest request) {
		List<UsersDTO> users=resultService.getUsers();
		request.setAttribute("users", users);
		return "users";
	}
	
}
