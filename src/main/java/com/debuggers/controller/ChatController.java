package com.debuggers.controller;

import com.debuggers.domain.Chat;
import com.debuggers.service.ChatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chats")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public ResponseEntity<Chat> createChat(@RequestBody Chat chat) {
        Chat createdChat = chatService.create(chat);
        return new ResponseEntity<>(createdChat, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<Chat> getChat(@RequestParam Long id) {
        Chat foundChat = chatService.read(id);
        return new ResponseEntity<>(foundChat, HttpStatus.OK);
    }

}
