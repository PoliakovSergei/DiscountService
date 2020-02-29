package com.sergo.das.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class BaseResponse {

    HttpStatus status;
    Integer code;
    String message;
}