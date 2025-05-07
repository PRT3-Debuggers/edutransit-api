package com.debuggers.service;

import com.debuggers.domain.Message;
import com.debuggers.repository.IMessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MessageService {
    private final IMessageRepository messageRepository;
    public MessageService(IMessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message create(Message message){
        return messageRepository.save(message);
    }

    public Message read(Long id){
        return messageRepository.findById(id).orElse(null);
    }

    public List<Message> readAll(){
        return messageRepository.findAll();
    }

    public Message update(Message message){
        return messageRepository.save(message);
    }

    public void delete(Long id){
        messageRepository.deleteById(id);
    }
}
