package com.sergo.das.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum  ResponseCodes {
    CLIENT_ADD_SUCCESS(100, "Клиент добавлен в базу."),
    CLIENT_GET_SUCCESS(100, "Информация о клиентах получена."),
    ADD_POINTS_SUCCESS(100, "Баллы успешно добавлены."),
    USE_POINTS_SUCCESS(100, "Баллы успешно списаны."),
    GET_POINTS_SUCCESS(100, "Информация о баллах получена."),
    GET_SERVICE_INFO(100, "Запрос информации о сервисе."),
    USE_POINTS_FAILED(101, "Не хватает баллов."),
    CLIENT_ALREADY_EXISTS(101, "Клиент с указанным номером уже зарегистрирован."),
    CLIENT_NOT_FOUND(101, "Клиент с указанным номером не найден."),
    NOT_ENOUGH_POINTS(101, "Недостаточно баллов для списания.");

    private final Integer code;
    private final String message;
}
