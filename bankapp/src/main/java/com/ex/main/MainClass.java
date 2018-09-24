package com.ex.main;

import com.ex.data.UserRepository;
import com.ex.models.User;

public class MainClass {
	
	public static void main(String[] args) {
		UserRepository repo = new UserRepository();
		
//		User u = new User();
//		u.setFirstName("Keith");
//		u.setLastName("Hibbs");
//		u.setUsername("keithibb");
//		u.setPassword("1234");
//		
//		repo.save(u);
		
		System.out.println(repo.findByUsername("keithibb"));
	}

}