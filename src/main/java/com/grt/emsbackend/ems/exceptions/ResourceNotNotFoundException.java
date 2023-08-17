package com.grt.emsbackend.ems.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotNotFoundException extends RuntimeException {

    public ResourceNotNotFoundException(String message){
        super(message);
    }

}
