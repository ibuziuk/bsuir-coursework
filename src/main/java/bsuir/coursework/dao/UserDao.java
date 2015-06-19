package bsuir.coursework.dao;

import bsuir.coursework.model.User;

public interface UserDao {

	User findByUserName(String username);

}
