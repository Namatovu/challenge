package com.example.demo.Repository;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entities.Entity_SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;

public interface AuthRepo extends JpaRepository <Entity_SystemUser,Long> {

    @Query(value="INSERT INTO system_user (email, password, created_on )" +

            " VALUES(:email, :password, :createdOn) RETURNING *;", nativeQuery=true)
    JSONObject createUser(
            @Param("email") String email,
            @Param("password") String password,
            @Param("createdOn") Timestamp createdOn
    );
}
