package com.xgl;

import feign.Feign;
import feign.gson.GsonDecoder;
import com.xgl.PersonClient.Person;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/25/9:18
 * @Description:
 */
public class PersonMain {
    public static void main(String[] args) {
        PersonClient personService = Feign.builder()
                                    .decoder(new GsonDecoder())
                                    .target(PersonClient.class,"http://localhost:8080/");
        Person person = personService.findById(2);
        System.out.println(person);
        System.out.println(person.id);
        System.out.println(person.name);
        System.out.println(person.age);
        System.out.println(person.message);
    }
}
