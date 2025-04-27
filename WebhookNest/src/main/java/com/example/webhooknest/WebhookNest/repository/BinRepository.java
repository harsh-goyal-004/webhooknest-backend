package com.example.webhooknest.WebhookNest.repository;

import com.example.webhooknest.WebhookNest.entity.Bin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BinRepository extends MongoRepository<Bin,String> {
}
