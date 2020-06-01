package com.sergo.das.service;

import com.sergo.das.entity.Client;
import java.util.List;

public interface ClientsService {
    void addClient(Long card_id);
    List<Client> getAll();

    void addPoints(Long clientCardId, Integer addedPoints);
    void usePoints(Long clientCardId, Integer usedPoints);
    Integer getUserPoints(Long clientCardId);
}
