package com.spibook.core.service;

import com.spibook.core.dao.exceptions.NoSuchUserException;
import com.spibook.core.dao.exceptions.UserAlreadyExistsException;
import com.spibook.core.entity.User;

import java.util.List;

public interface UserService {
User findUser(int id) throws NoSuchUserException;
List<User> findAll();
User save(User user) throws UserAlreadyExistsException;
User findByLogin(String login) throws NoSuchUserException;

}
