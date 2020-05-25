package xgl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auther: sise.xgl
 * @Date: 2020/6/4/15:51
 * @Description:
 */
@RestController
public class ZuulController {

    @Autowired
    MessageSender messageSender;


    @Resource
    PersonClient personClient;

    @RequestMapping("/send/{person}")
    public String ZuulRro(@PathVariable(value = "person") String person){

        System.out.println(person);
        User p = personClient.getPerson(person);
        String info = p.getUid()+"  "+p.getUsername();
        Message msg = MessageBuilder.withPayload(info.getBytes()).build();
        System.out.println("ZuulRro--------------");
        messageSender.send(info);

        return "SUCCESS";
    }
}
