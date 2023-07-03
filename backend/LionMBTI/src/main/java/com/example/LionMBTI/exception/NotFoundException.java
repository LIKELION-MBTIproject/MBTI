package com.example.LionMBTI.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "MBTI가 잘못되었거나 해당 MBTI 정보가 없습니다.";
    }
}
