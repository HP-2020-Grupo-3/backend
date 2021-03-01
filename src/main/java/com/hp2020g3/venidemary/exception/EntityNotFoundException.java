package com.hp2020g3.venidemary.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException() {
    }

    public EntityNotFoundException(String s) {
        super(s);
    }

    public EntityNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public EntityNotFoundException(Throwable throwable) {
        super(throwable);
    }
}
