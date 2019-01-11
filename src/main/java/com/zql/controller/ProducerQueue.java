package com.zql.controller;

import org.apache.activemq.ActiveMQConnectionConsumer;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Controller;

import javax.jms.*;

/**
 * queue模式
 * Created by 26725 on 2019/1/11.
 *
 */
@Controller
public class ProducerQueue {
    public void testMQProducerQueue() throws Exception{
        //1、创建工厂连接对象，需要制定ip和端口号
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        //使用连接工厂创建一个连接对象
        Connection connection = connectionFactory.createConnection();
        //开启连接
        connection.start();
        //使用连接对象创建一个会话
        Session session = connection.createSession();
        //使用会话创建目标对象,包含queue和topic（一对一模式和一对多模式）
        Queue queue = session.createQueue("test_queue");
        //使用会话创建生产者对象
        MessageProducer producer = session.createProducer(queue);
        //使用会话创建消息对象
        TextMessage textMessage = session.createTextMessage("hello,mq");
        //发送消息
        producer.send(textMessage);
        //关闭资源
        producer.close();
        session.close();
        connection.close();
    }
}
