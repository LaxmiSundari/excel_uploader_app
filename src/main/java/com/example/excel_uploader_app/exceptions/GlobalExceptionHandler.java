package com.example.excel_uploader_app.exceptions;

import com.example.excel_uploader_app.DTO.ResponseDTO;
import com.example.excel_uploader_app.exceptions.Types.GeneralServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(GeneralServiceException.class)
    public ResponseEntity<Object> handleGeneralServiceException(GeneralServiceException ex, WebRequest request) {
        log.error("GeneralServiceException: {}", ex.getMessage());
        ResponseDTO response = ResponseDTO.builder()
                .error(true)
                .message("Service Failure: " + ex.getMessage())
                .build();
        return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleOtherExceptions(Exception ex, WebRequest request) {
        log.error("Unhandled exception: {}", ex.getMessage());
        ResponseDTO response = ResponseDTO.builder()
                .error(true)
                .message("Unexpected error: " + ex.getMessage())
                .build();
        return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}