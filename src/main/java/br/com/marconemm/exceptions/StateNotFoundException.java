package br.com.marconemm.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
final public class StateNotFoundException extends Exception {
    private String msg;
    public StateNotFoundException(String uf) {
        super("The UF code passed [" + uf + "] is invalid.");
        msg = "asdasd";
    }
}
