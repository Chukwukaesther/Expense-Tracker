package com.semicolon.Expense_Tracker.controller;

import com.semicolon.Expense_Tracker.Exception.ExpenseTrackerException;
import com.semicolon.Expense_Tracker.dto.request.LoginUserRequest;
import com.semicolon.Expense_Tracker.dto.request.LogoutUserRequest;
import com.semicolon.Expense_Tracker.dto.request.RegisterUserRequest;
import com.semicolon.Expense_Tracker.dto.response.ApiResponse;
import com.semicolon.Expense_Tracker.dto.response.LoginUserResponse;
import com.semicolon.Expense_Tracker.dto.response.LogoutUserResponse;
import com.semicolon.Expense_Tracker.dto.response.RegisterUserResponse;
import com.semicolon.Expense_Tracker.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;


@RestController
@AllArgsConstructor
@RequestMapping("/api/User")
public class UserController {

    private final UserService userService;

    @PostMapping("/RegisterUser")
    public ResponseEntity<?> registerUser(@RequestBody RegisterUserRequest registerUserRequest){
        try{
            RegisterUserResponse result = userService.registerUser(registerUserRequest);
            return new ResponseEntity<>(new ApiResponse(true,result),CREATED);

        }catch(ExpenseTrackerException exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()),BAD_REQUEST);
        }
    }
    @PostMapping("/LoginUser")
    public ResponseEntity<?> loginUser(@RequestBody LoginUserRequest loginUserRequest){
        try{
            LoginUserResponse result = userService.loginUser(loginUserRequest);
            return new ResponseEntity<>(new ApiResponse(true,result),CREATED);

        }catch(ExpenseTrackerException exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()),BAD_REQUEST);
        }
    }

    @PostMapping("/LogoutUserUser")
    public ResponseEntity<?> logoutUser(@RequestBody LogoutUserRequest logoutUserRequest){
        try{
            LogoutUserResponse result = userService.logout(logoutUserRequest);
            return new ResponseEntity<>(new ApiResponse(true,result),CREATED);

        }catch(ExpenseTrackerException exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()),BAD_REQUEST);
        }
    }



}
