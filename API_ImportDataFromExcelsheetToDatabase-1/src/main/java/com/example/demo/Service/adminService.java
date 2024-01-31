package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.admin;

@Service
public class adminService {

	private List<admin> store = new ArrayList<>();

	public adminService() {
		store.add(new admin("admin", "12345"));
	}

	public List<admin> getAdmin() {
		return this.store;
	}
}
