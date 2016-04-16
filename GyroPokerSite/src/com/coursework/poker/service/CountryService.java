package com.coursework.poker.service;

import com.coursework.poker.dao.CountryDao;
import com.coursework.poker.entity.CountryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    CountryDao countryDao;

    public List<CountryEntity> getAll( ) {
       return countryDao.getAll();
    }

    public CountryEntity getById(int id){
        return countryDao.getById(id);
    }
}
