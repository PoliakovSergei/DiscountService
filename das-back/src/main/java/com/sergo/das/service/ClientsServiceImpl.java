package com.sergo.das.service;

import com.sergo.das.entity.Client;
import com.sergo.das.enums.ResponseCodes;
import com.sergo.das.repository.ClientsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientsServiceImpl implements ClientsService{

    private final ClientsRepository clientsRepository;

    public String addClient(Long cardId) {
        String responseMessage = ResponseCodes.CLIENT_ADD_SUCCESS.getMessage();
        if (clientsRepository.getClientByCardNumber(cardId) == null) {
            clientsRepository.save(new Client(cardId, 0, LocalDateTime.now()));
            log.info("Добавлен клиент с ID {}", cardId);
        } else {
            log.warn("Клиент с ID {} уже существует!", cardId);
            responseMessage = ResponseCodes.CLIENT_ALREADY_EXISTS.getMessage();
        }
        return responseMessage;
    }

    public List<Client> getAll() {
        return clientsRepository.findAll();
    }

    public String addPoints(Long clientCardId, Integer addedPoints) {
        String responseMessage = ResponseCodes.ADD_POINTS_SUCCESS.getMessage();
        Client client = clientsRepository.getClientByCardNumber(clientCardId);
        client.setPoints(client.getPoints() + addedPoints);
        clientsRepository.save(client);
        log.info("Клиенту с ID {} начислено {} баллов. В наличии: {} баллов.",
                clientCardId, addedPoints, client.getPoints());
        return responseMessage;
    }
    public String usePoints(Long clientCardId, Integer usedPoints) {
        String responseMessage = ResponseCodes.USE_POINTS_SUCCESS.getMessage();
        Client client = clientsRepository.getClientByCardNumber(clientCardId);
        if (client.getPoints() >= usedPoints) {
            client.setPoints(client.getPoints() - usedPoints);
            clientsRepository.save(client);
            log.info("У клиента с ID {} списано {} баллов. Остаток: {} баллов.",
                    clientCardId, usedPoints, client.getPoints());
        } else {
            log.warn("У клиента с ID {} не хватает баллов для списания! В наличии {}, к списанию {}.",
                    clientCardId, client.getPoints(), usedPoints);
            responseMessage = ResponseCodes.USE_POINTS_FAILED.getMessage();
        }
        return responseMessage;
    }
}
