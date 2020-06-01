package com.sergo.das.exception;

public class NotEnoughPointsException extends RuntimeException {
    public NotEnoughPointsException(Long clientId, Integer clientPoints, Integer needPoints) {
        super(buildExceptionMessage(clientId, clientPoints, needPoints));
    }

    private static String buildExceptionMessage(Long clientId, Integer clientPoints, Integer needPoints) {
        return "Недостаточно баллов у клиента с ID = " + clientId.toString() +". "
                + "В наличии " + clientPoints.toString() + ", "
                + "к списанию " + needPoints.toString() + ".";
    }
}
