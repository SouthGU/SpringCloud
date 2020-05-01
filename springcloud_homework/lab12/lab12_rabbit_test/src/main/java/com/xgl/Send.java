package com.xgl;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Auther: sise.xgl
 * @Date: 2020/6/1/9:13
 * @Description:
 */
public class Send {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        String queueName = "hello";
        channel.queueDeclare(queueName,false,false,false,null);
        String message = "Hello RabbitMQ!";
        for (int i =1 ; i<10; i++){
            channel.basicPublish("",queueName,null,message.getBytes());
        }
        channel.close();
        connection.close();

    }
}
