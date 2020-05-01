package com.xgl_2;

import feign.Feign;
import feign.jaxb.JAXBContextFactory;
import feign.jaxb.JAXBDecoder;
import feign.jaxb.JAXBEncoder;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/25/10:04
 * @Description:
 */
public class XMLTest {
    public static void main(String[] args) {
        JAXBContextFactory jaxbContextFactory = new JAXBContextFactory.Builder().build();
        PersonClient personClient = Feign.builder()
                                    .encoder(new JAXBEncoder(jaxbContextFactory))
                                    .decoder(new JAXBDecoder(jaxbContextFactory))
                                    .target(PersonClient.class,"http://localhost:8080/");
        PersonClient.Person person = new PersonClient.Person();
        person.Pid=1;
        person.Pname="xgl";
        person.Page=30;
        PersonClient.Result result = personClient.createPersonXML(person);
        System.out.println(result.Pmessage);
    }
}
