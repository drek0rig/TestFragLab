package ua.fraglabtest;

import ua.fraglabtest.commandprocessor.CommandAnalyzer;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/ws")
public class TestMain {
    @OnOpen
    public void open() {
        CommandAnalyzer.init();
    }

    @OnClose
    public void close() {
//        try {
            CommandAnalyzer.exit();
//        } catch (Exception ex) {
//            //Exception handling logic
//            ex.printStackTrace();
//        }
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        CommandAnalyzer.analyzeCommand(message);
    }
}
