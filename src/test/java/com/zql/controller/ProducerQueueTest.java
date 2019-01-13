package com.zql.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 张启磊 on 2019-1-13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProducerQueueTest {
    @Autowired
    private ProducerQueue producerQueue;
    @Test
    public void testMQProducerQueue() throws Exception {
        producerQueue.testMQProducerQueue();
    }

}