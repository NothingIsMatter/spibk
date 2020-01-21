package com.spibook.core.controller;

import com.spibook.core.dao.exceptions.NoSuchMessageException;
import com.spibook.core.dao.exceptions.NoSuchUserException;
import com.spibook.core.entity.Message;
import com.spibook.core.entity.User;
import com.spibook.core.service.MessageService;
import com.spibook.core.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("message")
public class MessageController {
    private MessageService messageService;
    private UserService userService;
    public MessageController(MessageService messageService, UserService userService) {
        this.messageService = messageService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<Message>> getAllMessages(){
        return new ResponseEntity<>(messageService.getAllMessages(), HttpStatus.OK);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Message> getMessages(@PathVariable(name = "id") int id) throws NoSuchMessageException {
      return new ResponseEntity<Message>(messageService.getMessage(id), HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> saveMessage(@RequestBody Map<String,String> body, @AuthenticationPrincipal String authenticationPrincipal) throws NoSuchUserException {
           Message message = new Message();
           message.setText(body.get("text"));
           message.setAuthor(userService.findByLogin(authenticationPrincipal));
           messageService.saveMessage(message);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
