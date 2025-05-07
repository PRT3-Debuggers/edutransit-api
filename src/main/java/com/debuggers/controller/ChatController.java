package com.debuggers.controller;

import com.debuggers.domain.Chat;
import com.debuggers.service.ChatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chats")
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public ResponseEntity<Chat> createChat(@RequestBody Chat chat) {
        Chat newChat = chatService.create(chat);
        if(newChat == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(newChat,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chat> getChat(@PathVariable Long id) {
        Chat chat = chatService.read(id);
        if(chat == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(chat, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Chat>> getAllChats(){
        List<Chat> chats = chatService.readAll();
        if(chats.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(chats, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chat> updateChat(@PathVariable Long id){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChat(@PathVariable Long id) {
        Chat chat = chatService.read(id);
        if(chat == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        chatService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
