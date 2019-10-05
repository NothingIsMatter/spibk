package com.spibook.core.service;

import com.spibook.core.dao.exceptions.NoSuchUserException;
import com.spibook.core.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    private UserService userService;
    public UserDetailsService(UserService userService){
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User byLogin = userService.findByLogin(username);
            return byLogin;
        } catch (NoSuchUserException ex){ throw new UsernameNotFoundException(ex.getMessage());}
    }
}
