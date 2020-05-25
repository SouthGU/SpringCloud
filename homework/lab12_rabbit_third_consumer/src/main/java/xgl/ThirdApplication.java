package xgl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * @Auther: sise.xgl
 * @Date: 2020/6/1/10:14
 * @Description:
 */
@SpringBootApplication
@EnableBinding(ReceiveService.class)
public class ThirdApplication {
    public static void main(String[] args) {
        SpringApplication.run(ThirdApplication.class,args);
    }

    @StreamListener("myInput")
    public void receive(byte[] msg){
        System.out.println("Third--接收到的消息："+ new String(msg));
    }
}
