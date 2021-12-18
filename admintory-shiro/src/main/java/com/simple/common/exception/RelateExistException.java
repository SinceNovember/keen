package com.simple.common.exception;

/**
 * 存在关联异常
 */
public class RelateExistException extends AdmintoryException {

    private static final long serialVersionUID = -994962710559017255L;

    public RelateExistException(String message) {
        super(message);
    }
}
