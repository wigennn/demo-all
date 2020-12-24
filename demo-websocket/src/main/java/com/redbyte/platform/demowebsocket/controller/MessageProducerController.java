package com.redbyte.platform.demowebsocket.controller;

import com.redbyte.platform.demowebsocket.common.MessageFormat;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author wangwq
 */
@RestController
public class MessageProducerController {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Value("${demo.websocket.rocketmq.topic}")
    private String topic;

    @GetMapping("/send")
    public String sendMsg() {
        MessageFormat messageFormat = new MessageFormat();
        messageFormat.setSourceId("0");
        messageFormat.setReceiveId("1");
        messageFormat.setTitle("title");
        messageFormat.setContent("消息发送时间为:" + LocalDateTime.now());
        messageFormat.setSendTime(new Date());
        rocketMQTemplate.convertAndSend(topic, messageFormat);
        return messageFormat.toString();
    }
}
