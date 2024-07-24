package com.example.bms.Service;

import com.example.bms.Repository.UserRepository;
import com.example.bms.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public Optional<User> findUserById(int userid) {
        return userRepository.findUserById(userid);
    }
}
