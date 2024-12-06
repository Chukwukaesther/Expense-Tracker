package com.semicolon.Expense_Tracker.service;

import com.semicolon.Expense_Tracker.Exception.UserNotFoundException;
import com.semicolon.Expense_Tracker.data.model.User;
import com.semicolon.Expense_Tracker.data.repository.UserRepository;
import com.semicolon.Expense_Tracker.dto.request.LoginUserRequest;
import com.semicolon.Expense_Tracker.dto.request.LogoutUserRequest;
import com.semicolon.Expense_Tracker.dto.request.RegisterUserRequest;
import com.semicolon.Expense_Tracker.dto.response.LoginUserResponse;
import com.semicolon.Expense_Tracker.dto.response.LogoutUserResponse;
import com.semicolon.Expense_Tracker.dto.response.RegisterUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest request) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = request.getPassword();
        if (password == null || password.length() == 0 || password.equals(" ")){
            throw new IllegalArgumentException("Password cannot be empty");
        }
        User user = new User();
        BeanUtils.copyProperties(request, user);
        userRepository.save(user);
        RegisterUserResponse response = new RegisterUserResponse();
        response.setMessage("Registration successful");
        return response;

    }

    @Override
    public LoginUserResponse loginUser(LoginUserRequest request) {
        User user = userRepository.findByEmail(request.getEmail());
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        LoginUserResponse response = new LoginUserResponse();
        response.setMessage("Login successful");

        return response;
    }

    @Override
    public  LogoutUserResponse logout(LogoutUserRequest request) {
        User user = userRepository.findByEmail(request.getEmail());
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        LogoutUserResponse response = new LogoutUserResponse();
        response.setMessage("Logout successful");

        return response;
    }


    @Override
    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("User not found"));
    }
}
