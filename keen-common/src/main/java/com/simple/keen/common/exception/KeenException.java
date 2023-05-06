package com.simple.keen.common.exception;

import lombok.Data;

/**
 * 通用业务异常
 *
 * @author SinceNovember
 * @date 2022/12/13
 */
@Data
public class KeenException extends RuntimeException {

    private Integer code;

    public KeenException() {
        super();
    }

    public KeenException(String message) {
        super(message);
    }

    public KeenException(int code, String message) {
        super(message);
        this.code = code;
    }
}
