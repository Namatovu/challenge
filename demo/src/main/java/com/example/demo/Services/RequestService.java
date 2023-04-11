package com.example.demo.Services;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.Repository.RequestRepo;
import com.example.demo.entities.Entity_IncomingRequests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
@Service
public class RequestService {

    private final RequestRepo requestRepo;
    @Autowired
    public RequestService(RequestRepo requestRepo) {
        this.requestRepo = requestRepo;
    }

    public JSONObject createRequest(JSONObject postObject) throws Exception{
        try {


            JSONObject request = requestRepo.createRequest(
                    postObject.getString("serviceCode"),
                    postObject.getString("serviceStatus"),
                    getCurrentTimeStamp()
            );
            return request;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public JSONObject getStats() throws Exception{
        try {
            return requestRepo.getNumberOfRequests();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public Timestamp getCurrentTimeStamp() {
        return new Timestamp(new Date().getTime());
    }
}
