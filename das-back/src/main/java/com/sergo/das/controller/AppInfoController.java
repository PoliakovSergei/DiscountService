package com.sergo.das.controller;

import com.sergo.das.dto.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppInfoController {
    @RequestMapping("/")
    public BaseResponse appInfo() {
        return new BaseResponse(
                HttpStatus.OK,
                200,
                "Add some info"
        );
    }
}
