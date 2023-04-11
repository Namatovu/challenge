package com.example.demo.controllers;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.Services.RequestService;
import com.example.demo.Utilities.GenericResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("request")
public class Request  {
    private  final RequestService requestService;

    public Request(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping("/getRequestStats")
    public GenericResponse getRequestStats() throws Exception {
        try{

           JSONObject resp= requestService.getStats();


           return new GenericResponse(0,"API Performance",resp);


        }  catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

}
