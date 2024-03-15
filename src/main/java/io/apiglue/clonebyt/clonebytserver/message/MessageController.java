package io.apiglue.clonebyt.clonebytserver.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/messages")

public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public List<Message> getMessages() {
        return messageService.getMessages();
    }

    @GetMapping("/{id}")
    public Message getMessagesById(@PathVariable("id") UUID id) {
        Message resposeMessage = messageService.getMessagesById(id);
        if (resposeMessage == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Message not found");
        }
        return resposeMessage;
    }

    @PostMapping
    public void addNewMessage(@RequestBody Message message) {
        messageService.addNewMessage(message);
    }
}
