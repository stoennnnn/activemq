package com.zql.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

/**
 * Created by 张启磊 on 2019-1-13.
 */
@Component
public class Producer {
    @Autowired
    private JmsTemplate jmsTemplate;
    public void sendMessage(Destination destination, String  message){
        jmsTemplate.convertAndSend(destination,message);
    }
}
