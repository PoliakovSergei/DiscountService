package com.sergo.das.exception;

public class ClientAlreadyExistException extends RuntimeException {
    public ClientAlreadyExistException(Long clientId) {
        super("Клиент c ID = " + clientId + " уже существует");
    }
}
