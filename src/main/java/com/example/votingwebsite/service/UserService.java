package com.example.votingwebsite.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.votingwebsite.model.User;
import com.example.votingwebsite.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(User user) {
        if (user.getRoles() == null || user.getRoles().isBlank()) {
            user.setRoles("ROLE_USER");
        }
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return null; // 或丟例外，表示尚未登入
        }

        String username = authentication.getName(); // 取得當前登入使用者的 username

        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isPresent()) {
            return userOpt.get(); // 找到使用者，回傳 User 物件
        } else {
            // 如果找不到使用者，可以選擇拋出例外或回傳 null
            throw new RuntimeException("User not found: " + username);
        }
    }

    public User findByUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        return userRepository.findByUsername(username).orElse(null);
    }
}

