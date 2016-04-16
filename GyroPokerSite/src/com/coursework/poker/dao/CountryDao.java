package com.coursework.poker.dao;

import com.coursework.poker.entity.CountryEntity;
import org.springframework.stereotype.Repository;

@Repository
public class CountryDao extends GeneralDao<CountryEntity> {

    public CountryDao() {
        super(CountryEntity.class);
    }

}
