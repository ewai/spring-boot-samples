package com.example.domain.service;

import com.example.domain.model.User;
import com.example.domain.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserService implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.info("username=" + username);

        if (username == null || "".equals(username)) {
            logger.info("username == null || \"\".equals(username)");
            throw new UsernameNotFoundException("Username is empty");
        }

        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found for name: " + username);
        }

        logger.info("user.getUsername()=" + user.getUsername());

        return user;
    }
}