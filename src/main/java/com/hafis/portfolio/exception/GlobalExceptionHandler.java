package com.hafis.portfolio.exception;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hafis.portfolio.dto.response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Object>> handleValidation(
        MethodArgumentNotValidException e
    ) {

        String message = e.getBindingResult()
                        .getFieldErrors()
                        .stream()
                        .map(err -> err.getField() + ": " + err.getDefaultMessage())
                        .collect(Collectors.joining(", "));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                            .body(ApiResponse.error(message));
                            
    }

    @ExceptionHandler({ResourceNotFoundException.class, UserNotFoundException.class})
    public ResponseEntity<ApiResponse<Object>> handleResourceNotFound (
        RuntimeException e
    ) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(ApiResponse.error(e.getMessage()));

    }

    @ExceptionHandler(DuplicateResourcesException.class)
    public ResponseEntity<ApiResponse<Object>> hnadleDuplicateResource (
        DuplicateResourcesException e
    ) {

        return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body(ApiResponse.error(e.getMessage()));

    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ApiResponse<Object>> handleUnauthorized (
        UnauthorizedException e
    ) {

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(ApiResponse.error(e.getMessage()));

    }

    @ExceptionHandler(FileUploadException.class)
    public ResponseEntity<ApiResponse<Object>> handleFileUpload (
        FileUploadException e
    ) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(ApiResponse.error(e.getMessage()));

    }
    
}
