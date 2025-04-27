package com.example.webhooknest.WebhookNest.controllers;

import com.example.webhooknest.WebhookNest.entity.RequestLog;
import com.example.webhooknest.WebhookNest.services.RequestLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class RequestLogController {

    @Autowired
    private RequestLogService requestLogService;

//    Get All Saved Requests from DB
    @GetMapping("/{binId}")
    public ResponseEntity<?> getAllRequests(@PathVariable String binId){
        List<RequestLog> requestLogList = requestLogService.getAllRequestLogs(binId);
        return new ResponseEntity<>(requestLogList, HttpStatus.OK);
    }

//    Save Request Header and Body in DB
    @PostMapping("/{binId}")
    public String getRequestLog(@PathVariable String binId, @RequestHeader Map<String, String> reqHeader, @RequestBody Map<String,String> reqBody){
        requestLogService.saveRequestLog(binId, reqHeader, reqBody);
        return "OK";
    }
}
