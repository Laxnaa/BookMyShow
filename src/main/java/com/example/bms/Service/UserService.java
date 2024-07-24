package com.example.bms.Service;

import com.example.bms.Repository.UserRepository;
import com.example.bms.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserService {
    public Optional<User> findUserById(int userid);
}
