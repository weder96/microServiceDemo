package com.wsousa.delivery.exception;

public class ApiNotFoundException extends Exception {

    public ApiNotFoundException(String message){
        super(message);
    }

    private void showException(String message) throws Exception {
        throw new Exception("Error ao Buscar Accounting ".concat(message));
    }
}

