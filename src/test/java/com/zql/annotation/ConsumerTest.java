package com.zql.annotation;

import org.apache.activemq.command.ActiveMQTopic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Destination;

/**
 * Created by 张启磊 on 2019-1-13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumerTest {
    @Autowired
    private Producer producer;
    @Test
    public void receiveQuenue() throws Exception {
        //queue模式队列
       // Destination destination = new ActiveMQQueue( "annotation.queue" );
        //topic模式队列
       Destination destination = new ActiveMQTopic("annotation.queue4");
        producer.sendMessage(destination, "woaini" );
    }

}