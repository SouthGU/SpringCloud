package com.xgl;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import lombok.Data;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/25/9:17
 * @Description:
 */
public interface PersonClient {
    @RequestLine("GET /person/{personId}")
    Person findById(@Param("personId") Integer personId);

    @RequestLine("POST /person/create")
    @Headers("Content-Type: application/json")
    String createPerson(Person person);

    @Data
    class Person{
        Integer id;
        String name;
        Integer age;
        String message;
    }
}
