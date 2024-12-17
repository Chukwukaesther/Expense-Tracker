package com.semicolon.Expense_Tracker.service;
import com.semicolon.Expense_Tracker.dto.request.PayStackRequest;
import com.semicolon.Expense_Tracker.dto.request.VerifyPayStackRequest;
import com.semicolon.Expense_Tracker.dto.response.PayStackResponse;
import com.semicolon.Expense_Tracker.dto.response.VerifyPayStackResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class PayStackServiceImpl implements PayStackService {
    private static final String url = "https://api.paystack.co/transaction/initialize";
    private static final String authorization = "Bearer sk_test_c565ddb8148ee2a13b08feedba67783b5244a903";

    @Override
    public PayStackResponse initializeTransaction(PayStackRequest payStackRequest) {
        RestTemplate restTemplate = new RestTemplate();
        // Create request headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authorization);
        headers.set("Content-Type", "application/json");
        if (!isValidEmail(payStackRequest.getEmail())) {
            throw new IllegalArgumentException("Invalid email address");
        }
        // Create request body
        // Wrap the request in an HttpEntity object
        HttpEntity<PayStackRequest> requestEntity = new HttpEntity<>(payStackRequest, headers);
        // Send the POST request
        ResponseEntity<PayStackResponse> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity,
                PayStackResponse.class);
        // Get the response body);
        return response.getBody();
        // Output the response

    }

    @Override
    public VerifyPayStackResponse verifyPayStackResponse(VerifyPayStackRequest verifyPayStackRequest) {

        String reference = "transaction_reference";  // Replace with the actual transaction reference
        RestTemplate restTemplate = new RestTemplate();

        // Create request headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authorization);

        // Wrap the headers in an HttpEntity object (no body required for GET request)
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        // Build the URL with the transaction reference
//        String url = urlTemplate.replace("{reference}", reference);

        // Send the GET request
        ResponseEntity<VerifyPayStackResponse> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
            VerifyPayStackResponse.class);

        // Output the response
        System.out.println(response.getBody());
        return null;
    }





    private static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(emailRegex);
    }

}
