package io.apiglue.clonebyt.clonebytserver.message;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter

public class Message {

    private UUID Id;
    private String content;
    private Date createdDate;
    private Date expiryDate;

    public Message() {
        Id = UUID.randomUUID();
        createdDate = new Date();
    }
}