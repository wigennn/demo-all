package com.redbyte.platform.demowebsocket.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 *
 * </p>
 *
 * @author wangwq
 */
@Slf4j
@ServerEndpoint("/webSocket/{uid}")
public class WebSocketServer {

    private static ConcurrentHashMap<String, WebSocketServer> webSocketSet = new ConcurrentHashMap<>();

    private Session session;

    private String uid;

    @OnOpen
    public void open(@PathParam("uid") String uid, Session session) {
        this.session = session;
        this.uid = uid;
        if (!StringUtils.isEmpty(uid)) {
            webSocketSet.put(uid, this);
        }
    }

    @OnClose
    public void close() {
        webSocketSet.remove(uid);
    }

    @OnMessage
    public void message(String msg) {
        log.info("来自客户端的消息:{}", msg);
    }

    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }
}
