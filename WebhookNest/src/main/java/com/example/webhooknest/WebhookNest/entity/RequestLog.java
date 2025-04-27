package com.example.webhooknest.WebhookNest.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Map;

@Document(collection = "request_log")
@Getter
@Setter
public class RequestLog {
    @Id
    private ObjectId id;
    private String binId;
    private String requestMethod;
    private Map<String, String> requestHeader;
    private Map<String,String> requestBody;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Indexed(expireAfter = "86000")
    LocalDateTime timestamp;
}
