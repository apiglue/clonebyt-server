package io.apiglue.clonebyt.clonebytserver.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getMessages() {
        return messageRepository.findAllValid();
    }

    public Message getMessagesById(UUID Id) {
        return messageRepository.findById(Id).orElse(null);
    }

    public void addNewMessage(Message message) {
        messageRepository.save(message);
    }
}