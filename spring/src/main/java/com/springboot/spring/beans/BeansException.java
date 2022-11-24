package com.springboot.spring.beans;

import org.springframework.core.NestedRuntimeException;
import org.springframework.lang.Nullable;

/**
 * @Author:zdd
 * @Date： 2022/11/16 13:17
 */
public class BeansException extends NestedRuntimeException {
    public BeansException(String msg) {
        super(msg);
    }

    /**
     * Create a new BeansException with the specified message
     * and root cause.
     * @param msg the detail message
     * @param cause the root cause
     */
    public BeansException(@Nullable String msg, @Nullable Throwable cause) {
        super(msg, cause);
    }


}
