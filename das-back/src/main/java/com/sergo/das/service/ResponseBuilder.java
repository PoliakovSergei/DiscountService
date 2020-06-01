package com.sergo.das.service;

import com.sergo.das.dto.BaseResponse;
import com.sergo.das.enums.ResponseCodes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



public class ResponseBuilder {
    public static ResponseEntity<BaseResponse> buildResponse(ResponseCodes responseCode, Object data) {
        BaseResponse response = new BaseResponse(responseCode.getCode(), responseCode.getMessage(), data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
