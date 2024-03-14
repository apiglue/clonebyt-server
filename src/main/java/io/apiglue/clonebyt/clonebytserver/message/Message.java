package io.apiglue.clonebyt.clonebytserver.message;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;
    private String content;
    private LocalDateTime createdDate = LocalDateTime.now();
    private LocalDateTime expirationDate = LocalDateTime.now().plusDays(1);

    public Message() {
    }

    public Message(UUID id, String content, LocalDateTime expiryDate) {
        Id = id;
        this.content = content;
        this.expirationDate = expiryDate;
    }

    public Message(String content, LocalDateTime expiryDate) {
        this.content = content;
        this.expirationDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Message{" +
                "Id=" + Id +
                ", content='" + content + '\'' +
                ", createdDate=" + createdDate +
                ", expiryDate=" + expirationDate +
                '}';
    }
}