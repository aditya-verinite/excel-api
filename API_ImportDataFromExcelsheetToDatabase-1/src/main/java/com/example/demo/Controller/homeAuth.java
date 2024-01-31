package com.example.demo.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.adminService;
import com.example.demo.model.admin;

@RestController
public class homeAuth {

	@RequestMapping("/welcome")
	public String welcome() {

		String text = "this is a private page";
		return text;
	}

	@GetMapping("current-user")
	public String getLoggedInUser(Principal principal) {
		return principal.getName();
	}

	@Autowired
	private adminService adminService;

	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/admin")
	public List<admin> getAdmin() {
		return this.adminService.getAdmin();
	}
}
