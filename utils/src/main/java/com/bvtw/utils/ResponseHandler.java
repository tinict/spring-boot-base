package com.bvtw.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ResponseHandler {

    public ResponseEntity<Object> generateResponse(
            Boolean isError,
            String numCode,
            String message,
            HttpStatus status,
            Object data
    ) {
        Map<String, Object> map = new HashMap<>();

        map.put("isError", isError);
        map.put("numCode", numCode);
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", data);

        return new ResponseEntity<>(map, status);
    }

    public ResponseEntity<Object> mapErrorToResponse(BindingResult result) {
        List<FieldError> fieldErrors = result.getFieldErrors();
        Map<String, String> errors = new HashMap<>();

        for (FieldError fieldError : fieldErrors) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return generateResponse(
                true,
                ApiCodes.INVALID_REQUEST,
                "Input Data Invalid",
                HttpStatus.BAD_REQUEST,
                errors
        );
    }
}