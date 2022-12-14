package com.bezkoder.spring.security.postgresql.payload.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TokenRefreshRequest {

    @NotBlank
    private String refreshToken;


}
