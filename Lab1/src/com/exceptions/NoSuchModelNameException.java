package com.exceptions;

public class NoSuchModelNameException extends Exception {

    public NoSuchModelNameException() {
        super("Модели с указанным именем не существует");
    }

    public NoSuchModelNameException(String msg) {
        super(msg);
    }
}
