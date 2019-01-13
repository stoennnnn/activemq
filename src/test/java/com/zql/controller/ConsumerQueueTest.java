package com.zql.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 26725 on 2019/1/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumerQueueTest {
    @Autowired
    private ConsumerQueue consumerQueue;
    @Test
    public void consumer() throws Exception {
       consumerQueue.consumer();
    }

}