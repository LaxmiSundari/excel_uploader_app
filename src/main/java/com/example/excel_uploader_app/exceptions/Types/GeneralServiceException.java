package com.example.excel_uploader_app.exceptions.Types;

public class GeneralServiceException extends RuntimeException {
    public GeneralServiceException(String message) {
        super(message);
    }

    public GeneralServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
