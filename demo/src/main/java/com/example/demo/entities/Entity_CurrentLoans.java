package com.example.demo.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "current_loans", schema = "public", catalog = "dfcu")
public class Entity_CurrentLoans {
    private long id;
    private String loanAcctIdentifier;
    private String customerIdentifier;
    private Date disbursementDt;
    private Double outstandingAmt;
    private String status;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "loan_acct_identifier")
    public String getLoanAcctIdentifier() {
        return loanAcctIdentifier;
    }

    public void setLoanAcctIdentifier(String loanAcctIdentifier) {
        this.loanAcctIdentifier = loanAcctIdentifier;
    }

    @Basic
    @Column(name = "customer_identifier")
    public String getCustomerIdentifier() {
        return customerIdentifier;
    }

    public void setCustomerIdentifier(String customerIdentifier) {
        this.customerIdentifier = customerIdentifier;
    }

    @Basic
    @Column(name = "disbursement_dt")
    public Date getDisbursementDt() {
        return disbursementDt;
    }

    public void setDisbursementDt(Date disbursementDt) {
        this.disbursementDt = disbursementDt;
    }

    @Basic
    @Column(name = "outstanding_amt")
    public Double getOutstandingAmt() {
        return outstandingAmt;
    }

    public void setOutstandingAmt(Double outstandingAmt) {
        this.outstandingAmt = outstandingAmt;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity_CurrentLoans that = (Entity_CurrentLoans) o;
        return id == that.id &&
                Objects.equals(loanAcctIdentifier, that.loanAcctIdentifier) &&
                Objects.equals(customerIdentifier, that.customerIdentifier) &&
                Objects.equals(disbursementDt, that.disbursementDt) &&
                Objects.equals(outstandingAmt, that.outstandingAmt) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, loanAcctIdentifier, customerIdentifier, disbursementDt, outstandingAmt, status);
    }
}
