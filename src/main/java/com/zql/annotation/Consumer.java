package com.zql.annotation;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * Created by 张启磊 on 2019-1-13.
 */
@Service
public class Consumer {
    @JmsListener(destination = "annotation.queue4")
    public void receiveStringTopic(String txt) {
        for (int i = 0; i < 10; i++) {

            System.out.println( "收到队列消息：" + txt );
        }
    }
}
