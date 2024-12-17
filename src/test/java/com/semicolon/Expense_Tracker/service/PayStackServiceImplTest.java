package com.semicolon.Expense_Tracker.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.semicolon.Expense_Tracker.controller.PayStackController;
import com.semicolon.Expense_Tracker.dto.request.PayStackRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class PayStackServiceImplTest {
@Autowired
    private PayStackServiceImpl payStackService;
private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void initializeTransaction() throws JsonProcessingException {
        PayStackRequest payStackRequest = PayStackRequest.builder()
                .email("fat@email.com")
                .amount("100")
                .build();
       var response = payStackService.initializeTransaction(payStackRequest);
        System.out.println(objectMapper.writeValueAsString(response));


    }
}