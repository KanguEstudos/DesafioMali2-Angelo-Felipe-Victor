package br.com.kangu.mcep.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class BadCepFormationException extends RuntimeException {

    public BadCepFormationException(String exception) {
        super(exception);
    }

}
