package com.sergo.das.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum  ResponseCodes {
    CLIENT_ADD_SUCCESS(100, "Клиент добавлен в базу."),
    ADD_POINTS_SUCCESS(100, "Баллы успешно добавлены."),
    USE_POINTS_SUCCESS(100, "Баллы успешно списаны."),
    USE_POINTS_FAILED(101, "Не хватает баллов."),
    CLIENT_ALREADY_EXISTS(101, "Клиент с указанным номером уже зарегистрирован.");

    private final Integer code;
    private final String message;
}
