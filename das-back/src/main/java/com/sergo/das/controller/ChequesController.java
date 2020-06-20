package com.sergo.das.controller;

import com.sergo.das.dto.BaseResponse;
import com.sergo.das.dto.NewChequeDto;
import com.sergo.das.enums.ResponseCodes;
import com.sergo.das.service.ResponseBuilder;
import com.sergo.das.service.interfaces.ChequeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cheque")
public class ChequesController {

    private final ChequeService chequeService;

    @PostMapping("/add")
    public ResponseEntity<BaseResponse> addCheque(@RequestBody NewChequeDto chequeInfo) {

        return ResponseBuilder.buildResponse(ResponseCodes.REGISTERED_NEW_CHEQUE, null);
    }
}
