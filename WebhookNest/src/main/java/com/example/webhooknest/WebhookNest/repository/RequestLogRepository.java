package com.example.webhooknest.WebhookNest.repository;

import com.example.webhooknest.WebhookNest.entity.RequestLog;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RequestLogRepository extends MongoRepository<RequestLog, ObjectId> {
    List<RequestLog> findRequestLogByBinId(String id);
}
