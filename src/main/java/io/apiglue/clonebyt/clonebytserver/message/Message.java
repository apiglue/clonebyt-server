package io.apiglue.clonebyt.clonebytserver.message;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
//    @SequenceGenerator(
//            name = "message_sequence",
//            sequenceName = "message_sequence",
//            allocationSize = 1)
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "message_sequence"
//    )

    private UUID Id;
    private String content;
    private Date createdDate;
    private Date expiryDate;

    public Message() {
    }

    public Message(UUID id, String content, Date expiryDate) {
        Id = id;
        this.content = content;
        this.createdDate = new Date();
        this.expiryDate = expiryDate;
    }

    public Message(String content, Date expiryDate) {
        this.content = content;
        this.createdDate = new Date();
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Message{" +
                "Id=" + Id +
                ", content='" + content + '\'' +
                ", createdDate=" + createdDate +
                ", expiryDate=" + expiryDate +
                '}';
    }
}