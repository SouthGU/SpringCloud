package com.xgl;

import feign.MethodMetadata;
import org.springframework.cloud.openfeign.support.SpringMvcContract;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/30/22:39
 * @Description:
 */

public class MyContract extends SpringMvcContract {

    @SuppressWarnings("deprecation")
    protected void processAnnotationOnMethod(MethodMetadata data, Annotation annotation, Method method) {
        //调用父类的方法，可以支持@RequestMapping注解
        super.processAnnotationOnMethod(data, annotation, method);
        //判断是MyUrl注解才进行处理
        if (MyUrl.class.isInstance(annotation)){
            //获取注解实例
            MyUrl myUrlAnn = method.getAnnotation(MyUrl.class);
            //获取配置的HTTP方法
            String httpMethod = myUrlAnn.method();
            String url = myUrlAnn.url();
            //将值配置到模板中
            data.template().method(httpMethod);
            data.template().append(url);
        }
    }
}
