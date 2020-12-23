package com.redbyte.platform.demowebsocket.websocket;

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
@ServerEndpoint("/webSocket/{uid}")
public class WebSocketServer {

    private static ConcurrentHashMap<String, WebSocketServer> webSocketSet = new ConcurrentHashMap<>();

    private Session session;

    @OnOpen
    public void open(@PathParam("uid") String uid, Session session) {
        this.session = session;

        if (!StringUtils.isEmpty(uid)) {
            webSocketSet.put(uid, this);
        }
    }

    @OnClose
    public void close() {

    }

    @OnMessage
    public void message(String msg, Session session) {

    }

    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }
}
