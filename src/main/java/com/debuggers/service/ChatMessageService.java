package com.debuggers.service;

import com.debuggers.domain.Chatmessage;
import com.debuggers.repository.IChatMessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatMessageService {
    private final IChatMessageRepository  chatMessageRepository;

    public ChatMessageService(IChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    public Chatmessage create(Chatmessage chatmessage){
        return chatMessageRepository.save(chatmessage);
    }

    public Chatmessage read(Long id){
        return chatMessageRepository.findById(id).orElse(null);
    }

    public List<Chatmessage> readAll(){
        return chatMessageRepository.findAll();
    }

    public Chatmessage update(Chatmessage chatmessage){
        return chatMessageRepository.save(chatmessage);
    }

    public void delete(Long id){
        chatMessageRepository.deleteById(id);
    }
}
