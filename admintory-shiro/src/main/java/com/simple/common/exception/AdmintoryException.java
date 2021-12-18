package com.simple.common.exception;

/**
 * 自定义异常
 */
public class AdmintoryException extends RuntimeException {

    private static final long serialVersionUID = -994962710559017255L;

    public AdmintoryException(String message) {
        super(message);
    }

    public AdmintoryException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
