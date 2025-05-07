package com.debuggers.service;

import com.debuggers.domain.Chat;
import com.debuggers.repository.IChatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {
    private final IChatRepository chatRepository;

    public ChatService(IChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public Chat create(Chat chat) {
        return chatRepository.save(chat);
    }

    public Chat read(Long id) {
        return chatRepository.findById(id).orElse(null);
    }

    public List<Chat> readAll(){
        return chatRepository.findAll();
    }

    public Chat update(Chat chat) {
        return chatRepository.save(chat);
    }

    public void delete(Long id) {
        chatRepository.deleteById(id);
    }
}
