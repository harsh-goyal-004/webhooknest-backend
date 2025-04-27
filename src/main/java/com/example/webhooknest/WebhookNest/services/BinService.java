package com.example.webhooknest.WebhookNest.services;


import com.example.webhooknest.WebhookNest.entity.Bin;
import com.example.webhooknest.WebhookNest.repository.BinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class BinService {

    @Autowired
    private BinRepository binRepository;



//    Save Newly Generated Bin in Database
    public Bin saveBin(){
        Bin bin = new Bin();
        bin.setId(UUID.randomUUID().toString().substring(0,7));
        bin.setCreatedAt(LocalDateTime.now());
        binRepository.save(bin);
        return bin;
    }
}
