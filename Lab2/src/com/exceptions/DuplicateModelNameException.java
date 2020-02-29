package com.exceptions;

public class DuplicateModelNameException extends Exception {

    public DuplicateModelNameException() {
        super("Модель с указанным именем уже существует");
    }

    public DuplicateModelNameException(String msg) {
        super(msg);
    }
}
