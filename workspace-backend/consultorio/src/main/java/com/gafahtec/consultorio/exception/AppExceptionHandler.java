package com.gafahtec.consultorio.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.gafahtec.consultorio.dto.response.ErrorMessage;
import com.gafahtec.consultorio.dto.response.ValidationErrors;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    public ResponseEntity<Object> handleValidationErrorException(MethodArgumentNotValidException ex,
            WebRequest webRequest) {

        Map<String, String> errors = new HashMap<>();

        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        }

        ValidationErrors validationErrors = new ValidationErrors(errors, new Date());

        return new ResponseEntity<>(validationErrors, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<Object> handleException(Exception ex, WebRequest webRequest) {
        ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                new Date(), ex.getMessage(), HttpStatus.NOT_FOUND.value(),

                request.getDescription(false));

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
    }

}
