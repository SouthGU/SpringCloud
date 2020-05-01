package com.xgl;

import lombok.Data;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/21/10:51
 * @Description:
 */
@Data
public class Person {
    Integer id;
    String name;
    Integer age;
    String message;

    public Person() {
    }

    public Person(Integer id, String name, Integer age, String message) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.message = message;
    }
}
