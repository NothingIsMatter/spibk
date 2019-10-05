package com.spibook.core.service;

import com.spibook.core.dao.MessageRepository;
import com.spibook.core.dao.exceptions.NoSuchMessageException;
import com.spibook.core.entity.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService{
    private MessageRepository messageRepository;
    public MessageServiceImpl(MessageRepository repository){
        this.messageRepository = repository;
    }
    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    public void saveMessage(Message message) {
        messageRepository.save(message);
    }

    @Override
    public Message getMessage(int id) throws NoSuchMessageException{
        return getAllMessages().stream().filter(message -> {
        return message.getId()==id;
        }).findFirst().orElseThrow(()->{
           return new NoSuchMessageException("Cant find message with id: "+id);
        });
    }
}
