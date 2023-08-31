package com.database.sample.exception.handler;


import com.database.sample.exception.Error;
import com.database.sample.exception.ServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ServerException.class)
    public ResponseEntity<Error> handleServerException(ServerException serverException) {
        log.info("handleServerException {}", serverException.getErrorMessage());
        var error = Error.builder().errorCode(String.valueOf(serverException.getHttpStatus().value())).errorMessage(serverException.getErrorMessage()).httpStatusCode(serverException.getHttpStatus().value()).build();
        return ResponseEntity.status(serverException.getHttpStatus()).body(error);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleException(Exception exception) {
        log.info("handleException {}", exception.getMessage());
        var error = Error.builder().errorCode("500").errorMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()).httpStatusCode(500).build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }


}
