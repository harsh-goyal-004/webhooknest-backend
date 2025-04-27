package com.example.webhooknest.WebhookNest.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "bin")
@Getter
@Setter
public class Bin {

    @Id
    private String id;
    private LocalDateTime createdAt;

}
