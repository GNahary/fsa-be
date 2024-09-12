package com.ng.fsa_server.membersOnly.exception;

public class UnAuthorizedUserException extends RuntimeException{

    public UnAuthorizedUserException() {
    }

    public UnAuthorizedUserException(String message) {
        super(message);
    }
}
