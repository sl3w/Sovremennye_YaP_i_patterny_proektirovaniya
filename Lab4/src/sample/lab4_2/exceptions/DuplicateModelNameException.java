package sample.lab4_2.exceptions;

public class DuplicateModelNameException extends Exception {

    public DuplicateModelNameException() {
        super("Модель с указанным именем уже существует");
    }

    public DuplicateModelNameException(String msg) {
        super(msg);
    }
}
