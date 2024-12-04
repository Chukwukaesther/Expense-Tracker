package com.semicolon.Expense_Tracker.controller;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.stereotype.Controller;

@Controller
public class PayStackController {

    private static final String PAYSTACK_SECRET_KEY = "sk_test_c565ddb8148ee2a13b08feedba67783b5244a903";
    private static final String BASE_URL = "https://api.paystack.co";

    public String initializePayment(String email, int amount) throws Exception {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        String jsonBody = "{"
                + "\"email\": \"" + email + "\","
                + "\"amount\": " + amount * 100
                + "}";

        RequestBody body = RequestBody.create(jsonBody, mediaType);
        Request request = new Request.Builder()
                .url(BASE_URL + "/transaction/initialize")
                .post(body)
                .addHeader("Authorization", "Bearer " + PAYSTACK_SECRET_KEY)
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new Exception("Failed to initialize payment: " + response.body().string());
            }
            return response.body().string();
        }
    }
}
