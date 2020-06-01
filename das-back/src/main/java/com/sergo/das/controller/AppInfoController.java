package com.sergo.das.controller;

import com.sergo.das.dto.BaseResponse;
import com.sergo.das.enums.ResponseCodes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.sergo.das.service.ResponseBuilder.buildResponse;

@RestController
public class AppInfoController {
    @RequestMapping("/")
    public ResponseEntity<BaseResponse> appInfo() {
        return buildResponse(ResponseCodes.CLIENT_ALREADY_EXISTS, "Information about service");
    }
}
