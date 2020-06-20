package com.sergo.das.service;

import com.sergo.das.entity.Client;
import com.sergo.das.exception.ClientAlreadyExistException;
import com.sergo.das.exception.ClientNotFoundException;
import com.sergo.das.exception.NotEnoughPointsException;
import com.sergo.das.repository.ClientsRepository;
import com.sergo.das.service.interfaces.ClientsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientsServiceImpl implements ClientsService {

    private final ClientsRepository clientsRepository;

    @Override
    public void addClient(Long cardId) {
        if (clientsRepository.getClientByCardNumber(cardId) == null) {
            clientsRepository.save(new Client(cardId, 0, LocalDateTime.now()));
            log.info("Добавлен клиент с ID {}", cardId);
        } else {
            log.error("Ошибка при добавлении клиента с ID = {}", cardId);
            throw new ClientAlreadyExistException(cardId);
        }
    }

    @Override
    public List<Client> getAll() {
        return clientsRepository.findAll();
    }

    @Override
    public void addPoints(Long clientCardId, Integer addedPoints) {
        Client client = clientsRepository.getClientByCardNumber(clientCardId);
        if (client == null) {
            log.error("Ошибка при добавлении баллов клиенту с ID = {}", clientCardId);
            throw new ClientNotFoundException(clientCardId);
        }
        client.setPoints(client.getPoints() + addedPoints);
        clientsRepository.save(client);
        log.info("Клиенту с ID {} начислено {} баллов. В наличии: {} баллов.",
                clientCardId, addedPoints, client.getPoints());
    }

    @Override
    public void usePoints(Long clientCardId, Integer usedPoints) {
        Client client = clientsRepository.getClientByCardNumber(clientCardId);
        if (client == null) {
            log.error("Ошибка при списывании баллов клиента с ID = {}", clientCardId);
            throw new ClientNotFoundException(clientCardId);
        }
        if (client.getPoints() >= usedPoints) {
            client.setPoints(client.getPoints() - usedPoints);
            clientsRepository.save(client);
            log.info("У клиента с ID {} списано {} баллов. Остаток: {} баллов.",
                    clientCardId, usedPoints, client.getPoints());
        } else {
            log.warn("У клиента с ID {} не хватает баллов для списания! В наличии {}, к списанию {}.",
                    clientCardId, client.getPoints(), usedPoints);
            throw new NotEnoughPointsException(clientCardId, client.getPoints(), usedPoints);
        }
    }

    @Override
    public Integer getUserPoints(Long clientCardId) {
        Client client = clientsRepository.getClientByCardNumber(clientCardId);
        if (client == null) {
            throw new ClientNotFoundException(clientCardId);
        }
        return client.getPoints();
    }
}
