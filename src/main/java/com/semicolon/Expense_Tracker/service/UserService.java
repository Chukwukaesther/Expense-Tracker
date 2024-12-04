package com.semicolon.Expense_Tracker.service;

import com.semicolon.Expense_Tracker.data.model.User;
import com.semicolon.Expense_Tracker.dto.request.LoginUserRequest;
import com.semicolon.Expense_Tracker.dto.request.LogoutUserRequest;
import com.semicolon.Expense_Tracker.dto.request.RegisterUserRequest;
import com.semicolon.Expense_Tracker.dto.response.LoginUserResponse;
import com.semicolon.Expense_Tracker.dto.response.LogoutUserResponse;
import com.semicolon.Expense_Tracker.dto.response.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse registerUser(RegisterUserRequest request);

    LoginUserResponse loginUser(LoginUserRequest request);

    LogoutUserResponse logout(LogoutUserRequest request);

    User findById(Long userId);
}
