package com.example.demo.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(ResourceNotFoundException exception, HttpServletRequest request){
        ApiError error = new ApiError();
        error.setTime(LocalDateTime.now());
        error.setError("NOT_FOUND");
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidationException(MethodArgumentNotValidException exception, HttpServletRequest request){
        Map<String, String> fieldErrors = new HashMap<>();
        for(FieldError fe: exception.getBindingResult().getFieldErrors()){
            fieldErrors.put(fe.getField(), fe.getDefaultMessage());
        }
        ApiError error = new ApiError();
        error.setTime(LocalDateTime.now());
        error.setError("VALIDATION_FAILED");
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Input validation failed");
        error.setPath(request.getRequestURI());
        error.setFieldErrors(fieldErrors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError> handleIllegalArgument(IllegalArgumentException ex,
                                                          HttpServletRequest req) {

        ApiError err = new ApiError();
        err.setTime(LocalDateTime.now());
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setError("BAD_REQUEST");
        err.setMessage(ex.getMessage());
        err.setPath(req.getRequestURI());

        return ResponseEntity.badRequest().body(err);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGenericException(Exception exception, HttpServletRequest request){
        ApiError error = new ApiError();
        error.setTime(LocalDateTime.now());
        error.setError("INTERNAL_SERVER_ERROR");
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setMessage(exception.getMessage());
        error.setPath(request.getRequestURI());

        return ResponseEntity.internalServerError().body(error);
    }
}
