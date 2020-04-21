package com.exception;

public class ModelPriceOutOfBoundsException extends Error {
    public ModelPriceOutOfBoundsException() {
    }

    public ModelPriceOutOfBoundsException(String message) {
        super(message);
    }

    public ModelPriceOutOfBoundsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ModelPriceOutOfBoundsException(Throwable cause) {
        super(cause);
    }

    public ModelPriceOutOfBoundsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
