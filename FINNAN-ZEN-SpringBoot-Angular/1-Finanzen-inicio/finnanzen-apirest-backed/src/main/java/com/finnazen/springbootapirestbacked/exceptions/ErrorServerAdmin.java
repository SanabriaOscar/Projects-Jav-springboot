package com.finnazen.springbootapirestbacked.exceptions;

public class ErrorServerAdmin extends RuntimeException {
    public ErrorServerAdmin() {
        super("Error en el servidor, contacte al administrador");
    }
}
