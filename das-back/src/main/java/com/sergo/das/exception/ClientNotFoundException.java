package com.sergo.das.exception;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(Long clientId) {
        super("Клиент c ID = " + clientId + " не найден");
    }
}
