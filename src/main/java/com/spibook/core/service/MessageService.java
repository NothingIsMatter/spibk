package com.spibook.core.service;

import com.spibook.core.dao.exceptions.NoSuchMessageException;
import com.spibook.core.entity.Message;

import java.util.List;

public interface MessageService {
    public List<Message> getAllMessages();
    Message getMessage(int id) throws NoSuchMessageException;
    void saveMessage(Message message);

}
