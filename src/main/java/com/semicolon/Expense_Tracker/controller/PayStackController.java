package com.semicolon.Expense_Tracker.controller;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.stereotype.Controller;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import java.util.Base64;

import static javax.crypto.Cipher.SECRET_KEY;

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

    public static boolean verify(String payload, String signature) throws Exception {

        Mac sha512Hmac = Mac.getInstance("HmacSHA512");
        SecretKeySpec keySpec = new SecretKeySpec(PAYSTACK_SECRET_KEY.getBytes(), "HmacSHA512");
        sha512Hmac.init(keySpec);

        byte[] macData = sha512Hmac.doFinal(payload.getBytes());
        String calculatedSignature = Base64.getEncoder().encodeToString(macData);

        return calculatedSignature.equals(signature);
    }



}
