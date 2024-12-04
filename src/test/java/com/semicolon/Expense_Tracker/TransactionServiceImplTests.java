package com.semicolon.Expense_Tracker;

import com.semicolon.Expense_Tracker.dto.request.CreateTransactionRequest;
import com.semicolon.Expense_Tracker.dto.response.CreateCategoryResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TransactionServiceImplTests{
    @Test
    public void TestThatICanCreateTransaction(){
        CreateTransactionRequest transaction = new CreateTransactionRequest();
        transaction.setDescription("RealEstateTransaction");
        transaction.setAmount(67.00);
        CreateCategoryResponse response = new CreateCategoryResponse();
        assertNotNull(response);
        assertEquals("Transaction created successfully", response.getDescription());



    }
}
