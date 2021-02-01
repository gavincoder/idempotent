package com.example.idempotent.idempotent.annotation;

import java.lang.annotation.*;

/**
 * @author ：Gavin
 * @see ：防止重复操作注解
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PreventDuplication {
    /**
     * 防重复操作限时标记数值（存储redis限时标记数值）
     */
    String value() default "value";

    /**
     * 防重复操作过期时间（借助redis实现限时控制）
     */
    long expireSeconds() default 10;
}
