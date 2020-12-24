package com.redbyte.platform.demowebsocket.consumer;

import com.redbyte.platform.demowebsocket.common.MessageFormat;
import com.redbyte.platform.demowebsocket.websocket.WebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * </p>
 *
 * @author wangwq
 */
@Slf4j
@Service
@RocketMQMessageListener(topic = "${demo.websocket.rocketmq.topic}", consumerGroup = "${rocketmq.producer.group}")
public class MessageConsumer implements RocketMQListener<MessageFormat> {

    @Autowired
    private WebSocketServer webSocketServer;

    @Override
    public void onMessage(MessageFormat messageFormat) {
        log.info("接收到的消息:{}", messageFormat);
        String reveiveId = messageFormat.getReceiveId();
        try {
            webSocketServer.send(reveiveId, messageFormat.toString());
        } catch (Exception e) {
            log.error("webSocketServer.send error", e);
        }
    }
}
