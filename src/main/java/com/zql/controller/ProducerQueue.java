package com.zql.controller;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Controller;

import javax.jms.*;

/**
 * queue模式
 * Created by 26725 on 2019/1/11.
 */
@Controller
public class ProducerQueue {
    public void testMQProducerQueue() throws Exception {
        //1、创建连接工厂，需要制定ip和端口号
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory( "tcp://127.0.0.1:61616 ");
        //使用连接工厂创建一个连接对象,默认是关闭的
        Connection connection = connectionFactory.createConnection();
        //开启连接
        connection.start();
        //前面的步骤都是为了创建session，使用连接对象创建一个会话
        //在这里可以设置配置参数：是否支持事务，签收模式
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //使用会话创建Destination对象,包含queue和topic（一对一模式和一对多模式）
        Queue queue = session.createQueue( "test_queue3" );
        // Topic topic = session.createTopic( "topic_queue" );
        //使用会话创建生产者对象：如果非持久化，那么mq重启后消息会丢失；如果持久化，可以持久化到ka'hdb/leveldb/mysql
        MessageProducer producer = session.createProducer( queue );
        //设置持久化方式
        producer.setDeliveryMode( DeliveryMode.NON_PERSISTENT );
        //使用会话创建消息对象
        TextMessage textMessage = session.createTextMessage( );
        textMessage.setStringProperty( "name","张启磊" );
        textMessage.setIntProperty( "age",22 );
        //发送消息
        producer.send( textMessage );
        //关闭资源
        producer.close();
        session.close();
        connection.close();
    }
}
