package io.apiglue.clonebyt.clonebytserver.message;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class MessageConfig {
    @Bean
    CommandLineRunner commandLineRunner(MessageRepository messageRepository) {
        return args -> {
            Message message = new Message("Hello, World", new Date(2025, 12, 31));
            messageRepository.save(message);
        };
    }
}
