package io.apiglue.clonebyt.clonebytserver.message;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class MessageRepositoryTests {

    @Autowired
    private MessageRepository messageRepository;

    @BeforeEach
    public void setUp() {
        Message message1 = new Message();
        message1.setContent("Test message - VALID");
        message1.setExpirationDate(LocalDateTime.now().plusDays(1));
        messageRepository.save(message1);

        Message message2 = new Message();
        message2.setContent("Test message - EXPIRED");
        message1.setExpirationDate(LocalDateTime.now().minusDays(1));
        messageRepository.save(message2);
    }

    @Test
    public void testGetValidMessages() {
        List<Message> messages = messageRepository.findAllValid();

        Assertions.assertThat(messages).isNotNull();
        Assertions.assertThat(messages.size()).isEqualTo(1);
    }
}
