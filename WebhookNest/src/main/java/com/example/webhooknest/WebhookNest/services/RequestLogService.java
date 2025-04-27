package com.example.webhooknest.WebhookNest.services;

import com.example.webhooknest.WebhookNest.entity.RequestLog;
import com.example.webhooknest.WebhookNest.repository.RequestLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;



@Component
public class RequestLogService {

  @Autowired
  private RequestLogRepository requestLogRepository;

//  Save Request Header and Body
    public void saveRequestLog(String binId, Map<String, String> reqHeader, Map<String, String> reqBody){
        RequestLog requestLog = new RequestLog();
        requestLog.setBinId(binId);
        requestLog.setRequestHeader(reqHeader);
        requestLog.setRequestMethod("GET");
        requestLog.setRequestBody(reqBody);
        requestLog.setTimestamp(LocalDateTime.now());
        requestLogRepository.save(requestLog);
    }

//    Get All Saved RequestLogs From DB
    public List<RequestLog> getAllRequestLogs(String binId){
       List<RequestLog> requestLogList = requestLogRepository.findRequestLogByBinId(binId);
       requestLogList.sort(Comparator.comparing(RequestLog::getTimestamp));
       Collections.reverse(requestLogList);
       return requestLogList.stream().limit(10).collect(Collectors.toList());
    }

}
