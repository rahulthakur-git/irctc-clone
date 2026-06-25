package com.rahul.irctc.service;

import com.rahul.irctc.entity.User;
import com.rahul.irctc.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) {
        if(userRepository.existsByEmail(user.getEmail())){
            throw new RuntimeException("Email is already registered");
        }
        return userRepository.save(user);
    }
}
