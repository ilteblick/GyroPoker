package com.coursework.poker.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "country", schema = "", catalog = "poker")
public class CountryEntity implements Serializable {
    private int idCountry;
    private String cCountryName;

    @Id
    @Column(name = "idCountry", nullable = false, insertable = true, updatable = true)
    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    @Basic
    @Column(name = "C_Country_Name", nullable = false, insertable = true, updatable = true, length = 45)
    public String getcCountryName() {
        return cCountryName;
    }

    public void setcCountryName(String cCountryName) {
        this.cCountryName = cCountryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountryEntity that = (CountryEntity) o;

        if (idCountry != that.idCountry) return false;
        if (cCountryName != null ? !cCountryName.equals(that.cCountryName) : that.cCountryName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCountry;
        result = 31 * result + (cCountryName != null ? cCountryName.hashCode() : 0);
        return result;
    }
}
