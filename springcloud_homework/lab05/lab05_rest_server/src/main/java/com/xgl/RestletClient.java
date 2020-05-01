package com.xgl;

import org.restlet.data.MediaType;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/21/10:52
 * @Description:
 */
public class RestletClient {

    @SuppressWarnings({"unchecked","rawtypes"})
    public static void main(String[] args) throws IOException {
        ClientResource client = new ClientResource("http://localhost:8080/person/1");
        Representation response = client.get(MediaType.APPLICATION_JSON);
        JacksonRepresentation jr = new JacksonRepresentation(response, HashMap.class);
        Map result = (HashMap) jr.getObject();
        System.out.println(result.get("PersonId")+"-"+result.get("Pname")+"-"+result.get("page")+"-"+result.get("message"));
    }
}
