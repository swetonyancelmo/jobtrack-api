package com.jobtrack.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<ApiErrorResponse> handleRecursoNaoEncontradoException(RecursoNaoEncontradoException ex){
        List<String> errors = List.of(ex.getMessage());

        ApiErrorResponse apiError = new ApiErrorResponse(
                "Recurso não encontrado",
                errors,
                HttpStatus.NOT_FOUND.value()
        );

        return new ResponseEntity<>(apiError, HttpStatus.NOT_ACCEPTABLE);
    }
}
