package com.coursework.poker.entity;

import javax.persistence.*;

@Entity
@Table(name = "city", schema = "", catalog = "poker")
public class CityEntity {
    private int idCity;
    private String cCityName;
    private CountryEntity countryByCountryIdCountry;

    @Id
    @Column(name = "idCity", nullable = false, insertable = true, updatable = true)
    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    @Basic
    @Column(name = "C_City_Name", nullable = false, insertable = true, updatable = true, length = 45)
    public String getcCityName() {
        return cCityName;
    }

    public void setcCityName(String cCityName) {
        this.cCityName = cCityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityEntity that = (CityEntity) o;

        if (idCity != that.idCity) return false;
        if (cCityName != null ? !cCityName.equals(that.cCityName) : that.cCityName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCity;
        result = 31 * result + (cCityName != null ? cCityName.hashCode() : 0);
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
