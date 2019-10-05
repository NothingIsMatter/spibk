package com.spibook.core.service;

import com.spibook.core.dao.UserDao;
import com.spibook.core.dao.exceptions.NoSuchUserException;
import com.spibook.core.dao.exceptions.UserAlreadyExistsException;
import com.spibook.core.entity.Role;
import com.spibook.core.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserDao userDao;
    private PasswordEncoder encoder;
    public UserServiceImpl(UserDao userDao, PasswordEncoder encoder){
this.userDao = userDao;
this.encoder = encoder;
    }

    @Override
    public User findUser(int id) throws NoSuchUserException {
        return findAll().stream().filter(u -> {
            return u.getId() == id;
        }).findFirst().orElseThrow(()->{
            return new NoSuchUserException("Cant find user with id "+id);
        });
    }

    @Override
    public User findByLogin(String login) throws NoSuchUserException {
        User byLogin = userDao.findByLogin(login);
        if (byLogin != null){
            return byLogin;
        } else throw new NoSuchUserException("Cant find user with login: "+login);
    }

    @Override
    public User save(User user) throws UserAlreadyExistsException {
        String realPassword = user.getPassword();
        user.setRoles(Collections.singleton(Role.ROLE_USER));
        user.setPassword(encoder.encode(realPassword));
        userDao.save(user);
        return user;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

}
