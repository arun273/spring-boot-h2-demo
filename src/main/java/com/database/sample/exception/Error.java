package com.database.sample.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Error {

    private String errorCode;
    private String errorMessage;
    private int httpStatusCode;
}
