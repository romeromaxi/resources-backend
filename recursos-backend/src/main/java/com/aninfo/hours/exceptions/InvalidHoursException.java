package com.aninfo.hours.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class InvalidHoursException extends RuntimeException {

    public InvalidHoursException(String message) {
        super(message);
    }
}
