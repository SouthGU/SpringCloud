package com.xgl_2;

import feign.Headers;
import feign.RequestLine;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/25/10:04
 * @Description:
 */
public interface PersonClient {


    @RequestLine("POST /person/createXML")
    @Headers("Content-Type: application/xml")
    Result createPersonXML(Person person);

    @Data
    @XmlRootElement
    class Person{

        @XmlElement
        Integer Pid;
        @XmlElement
        String Pname;
        @XmlElement
        Integer Page;
        @XmlElement
        String Pmessage;
    }

    @Data
    @XmlRootElement
    class Result{
        @XmlElement
        String Pmessage;
    }
}
