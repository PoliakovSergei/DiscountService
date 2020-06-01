package com.sergo.das.advice;

import com.sergo.das.exception.ClientAlreadyExistException;
import com.sergo.das.exception.ClientNotFoundException;
import com.sergo.das.exception.NotEnoughPointsException;
import com.sergo.das.dto.BaseResponse;
import com.sergo.das.enums.ResponseCodes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.sergo.das.service.ResponseBuilder.buildResponse;

@Slf4j
@ControllerAdvice
public class AdviceController {

    @ExceptionHandler({ClientAlreadyExistException.class})
    public ResponseEntity<BaseResponse> handleClientAlreadyExistException(ClientAlreadyExistException ex) {
        return buildResponse(ResponseCodes.CLIENT_ALREADY_EXISTS, ex.getMessage());
    }

    @ExceptionHandler({ClientNotFoundException.class})
    public ResponseEntity<BaseResponse> handleClientNotFoundException(ClientNotFoundException ex) {
        return buildResponse(ResponseCodes.CLIENT_NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler({NotEnoughPointsException.class})
    public ResponseEntity<BaseResponse> handleNotEnoughPointsException(NotEnoughPointsException ex) {
        return buildResponse(ResponseCodes.NOT_ENOUGH_POINTS, ex.getMessage());
    }
}
