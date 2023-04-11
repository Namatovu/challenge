package com.example.demo.Services;

import com.example.demo.Repository.AccountRepo;
import com.example.demo.Utilities.GenericResponse;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImple {
    private final AccountRepo accountRepo;
    private final RequestService requestService;
    @Autowired
    public AccountServiceImple(AccountRepo accountRepo, RequestService requestService) throws Exception {
        this.accountRepo = accountRepo;

        this.requestService = requestService;
    }


    public GenericResponse getAccountByAccountNo(String  acctNo) throws Exception{
        try{
            JSONObject serviceObj=new JSONObject();
            if(acctNo.length()==10 && acctNo!=null) {
                List<JSONObject> accounts = accountRepo.getAccountByAccountNo(acctNo);
                if (accounts.isEmpty()) {
                    serviceObj.put("serviceCode", "ACCOUNT_INQUIRY");
                    serviceObj.put("serviceStatus", "99");
                    sendRequest(serviceObj);

                    return new GenericResponse(99, "Account doesn't exist");


                } else {
                    serviceObj.put("serviceCode", "ACCOUNT_INQUIRY");
                    serviceObj.put("serviceStatus", "0");
                    sendRequest(serviceObj);
                    JSONObject account = accounts.get(0);
                    return new GenericResponse(0, "Account  exists", account);

                }
            }else{
                serviceObj.put("serviceCode", "ACCOUNT_INQUIRY");
                serviceObj.put("serviceStatus", "99");
                sendRequest(serviceObj);

                return new GenericResponse(99, "Account doesn't exist");
            }



        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }
    public GenericResponse getRunningLoanAccts(String  acctNo) throws Exception{
        try{

            JSONObject serviceObj=new JSONObject();
            List<JSONObject> runningLoans = accountRepo.getLoanDetails(acctNo);
            if(runningLoans.isEmpty()){
                serviceObj.put("serviceCode","LOAN_INQUIRY");
                serviceObj.put("serviceStatus","99");
               sendRequest(serviceObj);
                return  new GenericResponse(99,"No Loan Found");
            }else{
                serviceObj.put("serviceCode","LOAN_INQUIRY");
                serviceObj.put("serviceStatus","0");
                sendRequest(serviceObj);
                return  new GenericResponse(0,"The following are the running  loans",runningLoans);

            }




        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    public  void sendRequest(JSONObject obj){
        try {
            JSONObject createRequest = requestService.createRequest(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
