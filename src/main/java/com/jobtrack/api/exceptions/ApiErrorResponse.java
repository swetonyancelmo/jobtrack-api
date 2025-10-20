package com.jobtrack.api.exceptions;

import java.util.List;

public class ApiErrorResponse {
    private String message;
    private List<String> errors;
    private int status;

    public ApiErrorResponse(String message, List<String> errors, int status) {
        this.message = message;
        this.errors = errors;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public int getStatus() {
        return status;
    }
}
