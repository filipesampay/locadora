package br.ueg.progweb1.locadora.exceptions;

public class CustomException extends RuntimeException {
    public CustomException(String message, Throwable e){
        super(message, e);
    }
    public CustomException(String message){
        super(message);
    }
}
