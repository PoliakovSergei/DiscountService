package com.sergo.das.service;

import com.sergo.das.entity.Client;
import java.util.List;

public interface ClientsService {
    String addClient(Long card_id);
    List<Client> getAll();

    String addPoints(Long clientCardId, Integer addedPoints);
    String usePoints(Long clientCardId, Integer usedPoints);
}
