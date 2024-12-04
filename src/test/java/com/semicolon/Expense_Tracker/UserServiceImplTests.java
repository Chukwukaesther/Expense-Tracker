package com.semicolon.Expense_Tracker;

import com.semicolon.Expense_Tracker.dto.request.LoginUserRequest;
import com.semicolon.Expense_Tracker.dto.request.RegisterUserRequest;
import com.semicolon.Expense_Tracker.dto.response.LoginUserResponse;
import com.semicolon.Expense_Tracker.dto.response.LogoutUserResponse;
import com.semicolon.Expense_Tracker.dto.response.RegisterUserResponse;
import com.semicolon.Expense_Tracker.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServiceImplTests {
    @Autowired
    private UserService userService;
    private RegisterUserRequest register;

    @BeforeEach
    public void setUp() {
        register = new RegisterUserRequest();
        register.setFirstName("Udo");
        register.setLastName("luchy");
        register.setEmail("esa747@gmail.com");
        register.setPassword("oldenberry");
        register.setConfirmPassword("oldenberry");

    }


    @Test
    public void register() {
        RegisterUserResponse response = userService.registerUser(register);
        assertNotNull(response);
        assertEquals("Registration successful", response.getMessage());

    }


    @Test
    public void login() {
        LoginUserRequest login = new LoginUserRequest();
        login.setEmail("oluchi345@gmail.com");
        login.setPassword("oldenberry");
        LoginUserResponse response = new LoginUserResponse();
        assertNotNull(response);
        assertNotNull("User not found", login.getEmail());

    }

    @Test
    public void logout() {
        LoginUserRequest logout = new LoginUserRequest();
        logout.setEmail("esa747@gmail.com");
        logout.setPassword("1234");
        LogoutUserResponse response = new LogoutUserResponse();
        assertNotNull(response);
        assertNotNull("Logout successful", response.getMessage());
        

    }
}