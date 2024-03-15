package io.apiglue.clonebyt.clonebytserver.message;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class MessageServiceTests {

    @InjectMocks
    private MessageService messageService;
    @Mock
    private MessageRepository messageRepository;

    @Before("setUp")
    public void setUp() {
        messageRepository = mock(MessageRepository.class);
        messageService = new MessageService(messageRepository);
    }

    @Test
    @DisplayName("Test for Get Valid (Nonexpired) Messages method")
    public void MessageService_GetValidMessages() {

        List<Message> messages = new ArrayList<>();
        messages.add(new Message("Test message - VALID", LocalDateTime.now().plusDays(1)));

        Mockito.when(messageService.getMessages()).thenReturn(messages);
        assertTrue(messageService.getMessages().size() == 1);

    }

    @Test
    @DisplayName("Test for Get Invalid (Expired) Messages method")
    public void MessageService_GetInvalidMessages() {

        List<Message> messages = new ArrayList<>();
        messages.add(new Message("Test message - VALID", LocalDateTime.now().minusDays(1)));

        Mockito.when(messageService.getMessages()).thenReturn(messages);
        assertTrue(messageService.getMessages().size() == 1);

    }
}
