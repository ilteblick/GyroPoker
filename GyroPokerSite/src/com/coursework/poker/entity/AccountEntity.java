package com.coursework.poker.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Table(name = "account", schema = "", catalog = "poker")
public class AccountEntity implements Serializable {
    private int idAccount;
    private String aName;
    private String aSurename;
    private String aPassword;
    private String aEmail;
    private String aAddress;
    private String aPhone;
    private BigDecimal aBalance;
    private BigDecimal aPlayMoneyBalance;
    private CountryEntity country;

    @Id
    @Column(name = "idAccount", nullable = false, insertable = true, updatable = true)
    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    @Basic
    @Column(name = "A_Name", nullable = false, insertable = true, updatable = true, length = 45)
    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    @Basic
    @Column(name = "A_Surename", nullable = false, insertable = true, updatable = true, length = 45)
    public String getaSurename() {
        return aSurename;
    }

    public void setaSurename(String aSurename) {
        this.aSurename = aSurename;
    }

    @Basic
    @Column(name = "A_Password", nullable = false, insertable = true, updatable = true, length = 50)
    public String getaPassword() {
        return aName;
    }

    public void setaPassword(String aPassword) {
        this.aName = aName;
    }

    @Basic
    @Column(name = "A_Email", nullable = false, insertable = true, updatable = true, length = 45)
    public String getaEmail() {
        return aEmail;
    }

    public void setaEmail(String aEmail) {
        this.aEmail = aEmail;
    }

    @Basic
    @Column(name = "A_address", nullable = false, insertable = true, updatable = true, length = 100)
    public String getaAddress() {
        return aAddress;
    }

    public void setaAddress(String aAddress) {
        this.aAddress = aAddress;
    }

    @Basic
    @Column(name = "A_phone", nullable = false, insertable = true, updatable = true, length = 45)
    public String getaPhone() {
        return aPhone;
    }

    public void setaPhone(String aPhone) {
        this.aPhone = aPhone;
    }

    @Basic
    @Column(name = "A_balance", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getaBalance() {
        return aBalance;
    }

    public void setaBalance(BigDecimal aBalance) {
        this.aBalance = aBalance;
    }

    @Basic
    @Column(name = "A_PlayMoney_balance", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getaPlayMoneyBalance() {
        return aPlayMoneyBalance;
    }

    public void setaPlayMoneyBalance(BigDecimal aPlayMoneyBalance) {
        this.aPlayMoneyBalance = aPlayMoneyBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountEntity that = (AccountEntity) o;

        if (idAccount != that.idAccount) return false;
        if (aAddress != null ? !aAddress.equals(that.aAddress) : that.aAddress != null) return false;
        if (aBalance != null ? !aBalance.equals(that.aBalance) : that.aBalance != null) return false;
        if (aEmail != null ? !aEmail.equals(that.aEmail) : that.aEmail != null) return false;
        if (aName != null ? !aName.equals(that.aName) : that.aName != null) return false;
        if (aPhone != null ? !aPhone.equals(that.aPhone) : that.aPhone != null) return false;
        if (aPlayMoneyBalance != null ? !aPlayMoneyBalance.equals(that.aPlayMoneyBalance) : that.aPlayMoneyBalance != null)
            return false;
        if (aSurename != null ? !aSurename.equals(that.aSurename) : that.aSurename != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAccount;
        result = 31 * result + (aName != null ? aName.hashCode() : 0);
        result = 31 * result + (aSurename != null ? aSurename.hashCode() : 0);
        result = 31 * result + (aEmail != null ? aEmail.hashCode() : 0);
        result = 31 * result + (aAddress != null ? aAddress.hashCode() : 0);
        result = 31 * result + (aPhone != null ? aPhone.hashCode() : 0);
        result = 31 * result + (aBalance != null ? aBalance.hashCode() : 0);
        result = 31 * result + (aPlayMoneyBalance != null ? aPlayMoneyBalance.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Country_idCountry", referencedColumnName = "idCountry", nullable = false)
    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity countryByCountryIdCountry) {
        this.country = countryByCountryIdCountry;
    }
}
