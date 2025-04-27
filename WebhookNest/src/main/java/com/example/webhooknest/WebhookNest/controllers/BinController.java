package com.example.webhooknest.WebhookNest.controllers;

import com.example.webhooknest.WebhookNest.entity.Bin;
import com.example.webhooknest.WebhookNest.services.BinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class BinController {

    @Autowired
    private BinService binService;

//    Generate A Unique BinId
    @GetMapping("/bins")
    public ResponseEntity<?> generateBin(){
      Bin bin = binService.saveBin();
        Map<String,String> response = new HashMap<>();
        response.put("binId",bin.getId());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
