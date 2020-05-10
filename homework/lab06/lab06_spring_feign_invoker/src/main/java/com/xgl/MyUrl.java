package com.xgl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/30/22:34
 * @Description:
 */

@Target(METHOD)
@Retention(RUNTIME)
public @interface MyUrl {

    //定义url和method属性
    String url();
    String method();
}
