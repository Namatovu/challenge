package com.example.demo.controllers;

import com.example.demo.Services.AccountServiceImple;
import com.example.demo.Utilities.GenericResponse;
import jdk.nashorn.api.scripting.JSObject;

import com.alibaba.fastjson.JSONObject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("account")
public class Accounts {
    private final AccountServiceImple accountService;

    public Accounts(AccountServiceImple accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/check-account")
    public GenericResponse validateAccountNumber(@RequestBody  JSONObject accountObj) throws Exception {
        try{
            String accountNumber=accountObj.getString("acctNo");
            GenericResponse  accountCheck = accountService.getAccountByAccountNo(accountNumber);
                if(accountCheck.getReturnCode()==0){
               GenericResponse runningLoans=accountService.getRunningLoanAccts(accountNumber);

               if (runningLoans.getReturnObject()!=null) {
                   return new GenericResponse(runningLoans.getReturnCode(), runningLoans.getReturnMessage(), runningLoans.getReturnObject());
               }else{
                   return new GenericResponse(runningLoans.getReturnCode(), runningLoans.getReturnMessage());

               }
                }else{

                    return new GenericResponse(accountCheck.getReturnCode(),accountCheck.getReturnMessage(),accountCheck.getReturnObject());
                }





        }  catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }




}
