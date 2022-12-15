package br.com.kangu.mcep.exception.handler;

import br.com.kangu.mcep.exception.BadCepFormationException;
import br.com.kangu.mcep.exception.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handlerAllExceptions(Exception ex, WebRequest requiest) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), requiest.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BadCepFormationException.class)
    public final ResponseEntity<ExceptionResponse> badCepFormationExceptions(Exception ex, WebRequest requiest) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), requiest.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
