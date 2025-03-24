package com.airbnb.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;

/**
 * GlobalExceptionHandler class is responsible for handling exceptions globally.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * Handles MethodArgumentNotValidException it occurs when request body validation (@Valid on @RequestBody) fails.
     *
     * @param ex MethodArgumentNotValidException
     * @return ResponseEntity with errors
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, List<String>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        /**
         * Extracts field errors from the exception and maps them to a list of strings.
         */
        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .toList();
        return new ResponseEntity<>(getErrorsMap(errors), HttpStatus.BAD_REQUEST);
    }

    /**
     * Creates a map with the key "errors" and the value of the list of errors.
     *
     * @param errors list of errors
     * @return map with the key "errors" and the value of the list of errors
     */
    private Map<String, List<String>> getErrorsMap(List<String> errors) {
        return Map.of("errors", errors);
    }
}
