package com.coursework.poker.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by Airin on 02/04/2016.
 */
@Entity
@Table(name = "operation", schema = "", catalog = "poker")
public class OperationEntity {
    private int id;
    private BigDecimal oSumm;
    private Date oDate;
    private AccountEntity accountByIdAccount;
    private OperationTypeEntity operationTypeByIdOperationType;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "O_Summ", nullable = false, insertable = true, updatable = true, precision = 2)
    public BigDecimal getoSumm() {
        return oSumm;
    }

    public void setoSumm(BigDecimal oSumm) {
        this.oSumm = oSumm;
    }

    @Basic
    @Column(name = "O_Date", nullable = false, insertable = true, updatable = true)
    public Date getoDate() {
        return oDate;
    }

    public void setoDate(Date oDate) {
        this.oDate = oDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OperationEntity that = (OperationEntity) o;

        if (id != that.id) return false;
        if (oDate != null ? !oDate.equals(that.oDate) : that.oDate != null) return false;
        if (oSumm != null ? !oSumm.equals(that.oSumm) : that.oSumm != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (oSumm != null ? oSumm.hashCode() : 0);
        result = 31 * result + (oDate != null ? oDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_Account", referencedColumnName = "idAccount", nullable = false)
    public AccountEntity getAccountByIdAccount() {
        return accountByIdAccount;
    }

    public void setAccountByIdAccount(AccountEntity accountByIdAccount) {
        this.accountByIdAccount = accountByIdAccount;
    }

    @ManyToOne
    @JoinColumn(name = "id_Operation_type", referencedColumnName = "idOperation_type", nullable = false)
    public OperationTypeEntity getOperationTypeByIdOperationType() {
        return operationTypeByIdOperationType;
    }

    public void setOperationTypeByIdOperationType(OperationTypeEntity operationTypeByIdOperationType) {
        this.operationTypeByIdOperationType = operationTypeByIdOperationType;
    }
}
