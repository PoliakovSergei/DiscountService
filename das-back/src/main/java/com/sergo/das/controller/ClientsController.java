package com.sergo.das.controller;

import com.sergo.das.dto.BaseResponse;
import com.sergo.das.entity.Client;
import com.sergo.das.service.ClientsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientsController {

    private final ClientsService clientsService;

    @GetMapping("/add/{cardId}")
    public BaseResponse addClient(@PathVariable Long cardId) {
        log.info("Запрос на добавление клиента {}", cardId);
        String responseMessage = clientsService.addClient(cardId);
        return new BaseResponse(
                HttpStatus.OK,
                200,
                responseMessage
        );
    }

    @GetMapping("/get-all")
    public List<Client> getAll() {
        log.info("Запрос на получение списка всех клиентов.");
        return clientsService.getAll();
    }

    @GetMapping("/add-points/{cardId}/{addedPoints}")
    public BaseResponse addPoints(@PathVariable Long cardId, @PathVariable Integer addedPoints) {
        log.info("Запрос на добавление {} баллов клиенту {}", addedPoints, cardId);
        String responseMessage = clientsService.addPoints(cardId, addedPoints);
        return new BaseResponse(
                HttpStatus.OK,
                200,
                responseMessage
        );
    }

    @GetMapping("/use-points/{cardId}/{usedPoints}")
    public BaseResponse usePoints(@PathVariable Long cardId, @PathVariable Integer usedPoints) {
        log.info("Запрос на списание {} баллов клиенту {}", usedPoints, cardId);
        String responseMessage = clientsService.usePoints(cardId, usedPoints);
        return new BaseResponse(
                HttpStatus.OK,
                200,
                responseMessage
        );
    }
}
