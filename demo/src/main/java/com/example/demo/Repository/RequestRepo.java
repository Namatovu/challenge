package com.example.demo.Repository;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entities.Entity_IncomingRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;

public interface RequestRepo extends JpaRepository<Entity_IncomingRequests, Long> {

    @Query(value="INSERT INTO incoming_requests (service_code, service_status, created_on )" +

            " VALUES(:serviceCode, :serviceStatus, :createdOn) RETURNING *;", nativeQuery=true)
    JSONObject createRequest(
            @Param("serviceCode") String serviceCode,
            @Param("serviceStatus") String serviceStatus,
            @Param("createdOn") Timestamp createdOn
    );

    @Query(value=" Select (SELECT COALESCE(COUNT(id),0) AS number_of_requests FROM incoming_requests Y )  , " +
            "(SELECT COALESCE(COUNT(id),0) AS number_of_failed_validations FROM incoming_requests  WHERE  service_code='ACCOUNT_INQUIRY' and service_status='99') , " +
            " (Select COALESCE(COUNT (id),0) AS number_of_postive_requests from incoming_requests where service_code='LOAN_INQUIRY' and service_status='0')  , " +
            " (select COALESCE(COUNT (id),0) AS number_of_negative_requests from incoming_requests where service_code='LOAN_INQUIRY' and service_status='99')  " ,  nativeQuery=true)
    JSONObject getNumberOfRequests();


}
