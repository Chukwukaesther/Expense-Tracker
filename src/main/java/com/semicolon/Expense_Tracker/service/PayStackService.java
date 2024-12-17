package com.semicolon.Expense_Tracker.service;

import com.semicolon.Expense_Tracker.dto.request.PayStackRequest;
import com.semicolon.Expense_Tracker.dto.request.VerifyPayStackRequest;
import com.semicolon.Expense_Tracker.dto.response.PayStackResponse;
import com.semicolon.Expense_Tracker.dto.response.VerifyPayStackResponse;
import org.springframework.stereotype.Service;

@Service
public interface PayStackService {
    PayStackResponse initializeTransaction(PayStackRequest payStackRequest);
    VerifyPayStackResponse verifyPayStackResponse(VerifyPayStackRequest verifyPayStackRequest);
}
