package com.sergo.das.controller;

import com.sergo.das.dto.BaseResponse;
import com.sergo.das.entity.Client;
import com.sergo.das.enums.ResponseCodes;
import com.sergo.das.service.interfaces.ClientsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import static com.sergo.das.service.ResponseBuilder.buildResponse;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientsController {

    private final ClientsService clientsService;

    @GetMapping("/add/{cardId}")
    public ResponseEntity<BaseResponse> addClient(@PathVariable Long cardId) {
        log.info("Запрос на добавление клиента {}", cardId);
        clientsService.addClient(cardId);
        Integer userPoints = clientsService.getUserPoints(cardId);
        return buildResponse(ResponseCodes.CLIENT_ADD_SUCCESS, userPoints);
    }

    @GetMapping("/get-all")
    public ResponseEntity<BaseResponse> getAll() {
        log.info("Запрос на получение списка всех клиентов.");
        List<Client> clients = clientsService.getAll();
        return buildResponse(ResponseCodes.CLIENT_GET_SUCCESS, clients);
    }

    @GetMapping("/add-points/{cardId}/{addedPoints}")
    public ResponseEntity<BaseResponse> addPoints(@PathVariable Long cardId, @PathVariable Integer addedPoints) {
        log.info("Запрос на добавление {} баллов клиенту {}", addedPoints, cardId);
        clientsService.addPoints(cardId, addedPoints);
        Integer userPoints = clientsService.getUserPoints(cardId);
        return buildResponse(ResponseCodes.ADD_POINTS_SUCCESS, userPoints);
    }

    @GetMapping("/use-points/{cardId}/{usedPoints}")
    public ResponseEntity<BaseResponse> usePoints(@PathVariable Long cardId, @PathVariable Integer usedPoints) {
        log.info("Запрос на списание {} баллов клиенту {}", usedPoints, cardId);
        clientsService.usePoints(cardId, usedPoints);
        Integer userPoints = clientsService.getUserPoints(cardId);
        return buildResponse(ResponseCodes.USE_POINTS_SUCCESS, userPoints);
    }

    @GetMapping("get-points/{cardId}")
    public ResponseEntity<BaseResponse> getPoints(@PathVariable Long cardId) {
        log.info("Запрос на получение баллов клиента {}", cardId);
        Integer userPoints = clientsService.getUserPoints(cardId);
        return buildResponse(ResponseCodes.GET_POINTS_SUCCESS, userPoints);
    }
}
