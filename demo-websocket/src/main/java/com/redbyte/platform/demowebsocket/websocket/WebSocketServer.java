package com.redbyte.platform.demowebsocket.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 *
 * </p>
 *
 * @author wangwq
 */
@Slf4j
@Service
@ServerEndpoint("/websocket/{uid}")
public class WebSocketServer {

    private Session session;
    private String uid;

    private ConcurrentHashMap<String, WebSocketServer> webSocketServerMap = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(@PathVariable("uid") String uid, Session session) {
        this.uid = uid;
        this.session = session;
        webSocketServerMap.put(uid, this);
    }

    @OnClose
    public void onClose() {
        webSocketServerMap.remove(this.uid);
    }

    @OnError
    public void onError(Throwable throwable) {
        log.error("websocket发送错误: {}", throwable);
    }

    @OnMessage
    public void onMessage(String message) {
        log.info("来自websocket接受的消息: {}", message);
    }

    public void send(String uid, String message) throws Exception {
        if (webSocketServerMap.containsKey(uid)) {
            webSocketServerMap.get(uid).sendMessage(message);
        } else {
            log.warn("用户不在线：{}", uid);
        }
    }

    private void sendMessage(String message) throws Exception {
        this.session.getBasicRemote().sendText(message);
    }

    public void sendAll(String message) {
        try {
            for (String key : webSocketServerMap.keySet()) {
                webSocketServerMap.get(key).sendMessage(message);
            }
        } catch (Exception e) {
            log.error("sendAll Exception:{}");
        }
    }
}
