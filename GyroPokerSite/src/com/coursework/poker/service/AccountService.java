package com.coursework.poker.service;

import com.coursework.poker.dao.AccountDao;
import com.coursework.poker.entity.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountDao accountDao;

    public AccountEntity login(String email, String password) {
        AccountEntity baseAccount = accountDao.getByEmail(email);
        if (baseAccount != null && baseAccount.getaPassword().equals(password)) {
            return baseAccount;
        } else {
            return null;
        }
    }

    public void createAccount(AccountEntity accountEntity) {
        accountDao.saveOrUpdate(accountEntity);
    }
}
