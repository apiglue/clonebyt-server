package io.apiglue.clonebyt.clonebytserver.message;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class MessageConfig {
    @Bean
    CommandLineRunner commandLineRunner(MessageRepository messageRepository) {
        return args -> {
            Message message = new Message("Hello, World", LocalDateTime.now().plusYears(1));
            messageRepository.save(message);
        };
    }
}
