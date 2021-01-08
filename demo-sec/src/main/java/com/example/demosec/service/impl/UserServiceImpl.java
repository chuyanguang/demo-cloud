package com.example.demosec.service.impl;

import com.example.demosec.dao.UserRepository;
import com.example.demosec.entity.User;
import com.example.demosec.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByName(String name) {
        return userRepository.getUserByName(name);
    }
}
