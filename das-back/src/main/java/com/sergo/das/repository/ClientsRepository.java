package com.sergo.das.repository;

import com.sergo.das.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends JpaRepository<Client, Long> {

    Client getClientByCardNumber(Long cardNumber);
}
