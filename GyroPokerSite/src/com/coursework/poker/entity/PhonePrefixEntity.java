package com.coursework.poker.entity;

import javax.persistence.*;

/**
 * Created by Airin on 02/04/2016.
 */
@Entity
@Table(name = "phone_prefix", schema = "", catalog = "poker")
public class PhonePrefixEntity {
    private int idPhonePrefix;
    private String pPrefix;
    private CountryEntity countryByCountryIdCountry;

    @Id
    @Column(name = "idPhone_Prefix", nullable = false, insertable = true, updatable = true)
    public int getIdPhonePrefix() {
        return idPhonePrefix;
    }

    public void setIdPhonePrefix(int idPhonePrefix) {
        this.idPhonePrefix = idPhonePrefix;
    }

    @Basic
    @Column(name = "P_prefix", nullable = false, insertable = true, updatable = true, length = 5)
    public String getpPrefix() {
        return pPrefix;
    }

    public void setpPrefix(String pPrefix) {
        this.pPrefix = pPrefix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhonePrefixEntity that = (PhonePrefixEntity) o;

        if (idPhonePrefix != that.idPhonePrefix) return false;
        if (pPrefix != null ? !pPrefix.equals(that.pPrefix) : that.pPrefix != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPhonePrefix;
        result = 31 * result + (pPrefix != null ? pPrefix.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Country_idCountry", referencedColumnName = "idCountry", nullable = false)
    public CountryEntity getCountryByCountryIdCountry() {
        return countryByCountryIdCountry;
    }

    public void setCountryByCountryIdCountry(CountryEntity countryByCountryIdCountry) {
        this.countryByCountryIdCountry = countryByCountryIdCountry;
    }
}
