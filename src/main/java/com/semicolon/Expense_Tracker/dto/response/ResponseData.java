package com.semicolon.Expense_Tracker.dto.response;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseData {
    private  String authorization_url;
    private  String access_code;
    private  String reference;
}
