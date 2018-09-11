package com.revature.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.model.User;
import com.revature.model.UserInformation;

public class UserService {

	private static UserDao userDao = UserDaoImpl.getInstance();
	
	
	// 1. Read the Request body (JSON), and set it to the `json` String variable
	// 2. Using the ObjectMapper, map the json into an object of type User
	// 3. Perform rest of logic that requires a User POJO
	public static UserInformation login(HttpServletRequest req, HttpServletResponse resp) {
		ObjectMapper mapper = new ObjectMapper();
		User user = null;
		try {
			user = mapper.readValue(req.getReader(), User.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		User authorized = userDao.getUser(user.getUsername());
		if (userDao.getPasswordHash(user).equals(authorized.getPassword())) {
			UserInformation temp = userDao.getUserInformation(user.getUsername());
			HttpSession session = req.getSession();
			session.setAttribute("userinfo", temp);
			return temp;
		}
		return null;		
		
//		return userDao.getUserInformation(user.getUsername());

	}
	public static Object checkSession(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		return session.getAttribute("userinfo");
	}
	
	public static Object logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		return null;
	}
}