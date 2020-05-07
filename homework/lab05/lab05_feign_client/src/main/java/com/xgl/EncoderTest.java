package com.xgl;

import feign.Feign;
import feign.gson.GsonEncoder;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/21/12:00
 * @Description:
 */
public class EncoderTest {
    public static void main(String[] args) {
        PersonClient personClient = Feign.builder()
                                    .encoder(new GsonEncoder())
                                    .target(PersonClient.class,"http://localhost:8080/");
        PersonClient.Person person = new PersonClient.Person();
        person.id=1;
        person.name="Tommy";
        person.age=30;
        String response = personClient.createPerson(person);
        System.out.println(response);
    }
}
