package com.zql.controller;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Controller;

import javax.jms.*;
import java.io.IOException;

/**
 * Created by 26725 on 2019/1/11.
 */
@Controller
public class ConsumerQueue {
    public void consumer() throws JMSException, IOException {
        //1、创建工厂连接对象，需要制定ip和端口号
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        //使用连接工厂创建一个连接对象
        Connection connection = connectionFactory.createConnection();
        connection.setClientID( "consumer_persistant1" );
        //开启连接
        connection.start();
        //使用连接对象创建一个会话
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //使用会话创建目标对象,包含queue和topic（一对一模式和一对多模式）
        Topic topic = session.createTopic("test_queue3");
        //设置持久化
        session.createDurableSubscriber( topic,"consumer_persistant1" );
        //创建consumer对象
        MessageConsumer consumer = session.createConsumer(topic);
        //异步接收消息：注册一个实现了messageListener接口的对象到MessageConsumer
        //MessageListener必须要有一个实现方法，onMessage
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                if (message instanceof  TextMessage){
                    TextMessage textMessage = (TextMessage)message;
                    try {
                        System.out.println(textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        //等待接收消息
        System.in.read();
        //关闭资源
        consumer.close();
        session.close();
        connection.close();
    }
}
