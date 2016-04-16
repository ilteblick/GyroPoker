package com.coursework.poker.entity;

import javax.persistence.*;

/**
 * Created by Airin on 02/04/2016.
 */
@Entity
@Table(name = "operation_type", schema = "", catalog = "poker")
public class OperationTypeEntity {
    private int idOperationType;
    private String otType;

    @Id
    @Column(name = "idOperation_type", nullable = false, insertable = true, updatable = true)
    public int getIdOperationType() {
        return idOperationType;
    }

    public void setIdOperationType(int idOperationType) {
        this.idOperationType = idOperationType;
    }

    @Basic
    @Column(name = "OT_type", nullable = false, insertable = true, updatable = true, length = 45)
    public String getOtType() {
        return otType;
    }

    public void setOtType(String otType) {
        this.otType = otType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OperationTypeEntity that = (OperationTypeEntity) o;

        if (idOperationType != that.idOperationType) return false;
        if (otType != null ? !otType.equals(that.otType) : that.otType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOperationType;
        result = 31 * result + (otType != null ? otType.hashCode() : 0);
        return result;
    }
}
