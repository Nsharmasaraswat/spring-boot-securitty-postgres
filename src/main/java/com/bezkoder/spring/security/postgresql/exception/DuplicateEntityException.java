package com.bezkoder.spring.security.postgresql.exception;

public class DuplicateEntityException extends RuntimeException {

    public DuplicateEntityException(String objectName) {
        super(objectName + " " + "already Present");
    }
}
