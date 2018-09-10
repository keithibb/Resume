package com.ex.dao;

import com.ex.beans.User;
import com.ex.beans.UserInfo;

public interface UserDao {

	User getUser(String username);
	String getPasswordHash(User user);
	UserInfo getUserInfo(String username);
}