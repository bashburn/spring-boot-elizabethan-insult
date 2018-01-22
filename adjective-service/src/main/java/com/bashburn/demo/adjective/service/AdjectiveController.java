package com.bashburn.demo.adjective.service;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

@RestController
public class AdjectiveController {
  private final AdjectiveServiceWebSocketHandler handler = new AdjectiveServiceWebSocketHandler();
  private final AdjectiveSource source = new AdjectiveSource();
  private final AtomicBoolean failswitch = new AtomicBoolean(true);

  @RequestMapping("/api/adjective")
  public ResponseEntity<String> getAdjective() {
    if(failswitch.get()) {
      String bothAdjectives = String.format("%s %s", source.firstAdjective(), source.secondAdjective());
      failswitch.set(false);
      return new ResponseEntity<>(bothAdjectives, HttpStatus.OK);
    } else {
      failswitch.set(true);
      return new ResponseEntity<>("Adjective Service Down", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @Bean
  public AdjectiveServiceWebSocketHandler getHandler() {
    return this.handler;
  }

  private class AdjectiveServiceWebSocketHandler implements WebSocketHandler {
    private Queue<WebSocketSession> currentSessions = new ConcurrentLinkedQueue<WebSocketSession>();

    void sendMessage(String message) throws IOException {
      TextMessage textMessage = new TextMessage(message);
      for (WebSocketSession session : currentSessions) {
        session.sendMessage(textMessage);
      }
    }

    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
      currentSessions.add(webSocketSession);
    }

    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {

    }

    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {

    }

    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
      currentSessions.remove(webSocketSession);

    }

    public boolean supportsPartialMessages() {
      return false;
    }
  }
}
