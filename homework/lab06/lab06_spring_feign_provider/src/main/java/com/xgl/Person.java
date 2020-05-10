package com.xgl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/30/21:10
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private Integer id;
    private String name;
    private Integer age;
    private String message;

    public Person(Integer id, String name, Integer age) {
        super();
        this.id = id ;
        this.name = name;
        this.age = age;
    }
}
