package com.example.let_server.domain.auth.error;

import com.example.let_server.global.error.CustomError;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum AuthError implements CustomError {
    WRONG_PASSWORD(400, "Wrong password"),
    ;

    private final int status;
    private final String message;

    @Override
    public String getCode() {
        return name();
    }
}
