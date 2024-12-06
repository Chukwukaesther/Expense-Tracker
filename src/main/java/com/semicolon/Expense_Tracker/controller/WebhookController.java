package com.semicolon.Expense_Tracker.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/webhooks")
public class WebhookController {

    @PostMapping("/payStack")
    public ResponseEntity<String> handlePayStackWebhook(@RequestBody Map<String, Object> payload) {
        System.out.println("Webhook received: " + payload);
        return new ResponseEntity<>("Webhook processed", HttpStatus.OK);
    }
    @PostMapping("/webhook")
    public String handleWebhook(@RequestBody String payload, @RequestHeader("x-paystack-signature") String signature) {
        try { boolean isVerified = PayStackController.verify(payload, signature);
            if (isVerified) {
                 return "Event verified";
                 } else{
                return "Invalid signature";
            }
            }catch (Exception e) {
            e.printStackTrace();
            return "Error verifying signature";
        }
    }

}


