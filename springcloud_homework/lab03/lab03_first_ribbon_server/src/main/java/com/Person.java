package com;

import lombok.Data;

/**
 * @Auther: sise.xgl
 * @Date: 2020/3/16/12:57
 * @Description:
 */
@Data
public class Person {
    Integer PersonId;
    String Pname;
    int page;

    public Person(Integer personId, String pname, int page) {
        PersonId = personId;
        Pname = pname;
        this.page = page;
    }
}
