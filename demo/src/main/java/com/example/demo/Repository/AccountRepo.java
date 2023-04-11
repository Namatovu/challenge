package com.example.demo.Repository;

import com.example.demo.entities.Entity_Accounts;
import com.alibaba.fastjson.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepo extends JpaRepository<Entity_Accounts, Long> {

    @Query(value="select i.id as id,  i.account_name as name, i.account_no as account_number " +
            " from accounts i " +

            " where i.account_no =:account_no ", nativeQuery=true)
    List<JSONObject> getAccountByAccountNo(
            @Param("account_no") String  account_no);

    @Query(value="select i.id as id,  p.account_name,i.loan_acct_identifier , i.customer_identifier ,i.disbursement_dt,i.outstanding_amt,i.status " +
            " from current_loans i " +
            " join accounts p on p.account_no=i.customer_identifier " +

            " where i.outstanding_amt > 0   and i.customer_identifier=:acctNo", nativeQuery=true)
    List<JSONObject> getLoanDetails(
            @Param("acctNo") String acctNo
    );

}
