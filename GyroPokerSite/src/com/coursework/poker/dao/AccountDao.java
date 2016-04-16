package com.coursework.poker.dao;

import com.coursework.poker.entity.AccountEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDao extends GeneralDao<AccountEntity> {

    public AccountDao() {
        super(AccountEntity.class);
    }

    public AccountEntity getByEmail(String aEmail) {
        Criteria cr = getCurrentSession().createCriteria(AccountEntity.class);
        cr.add(Restrictions.eq("aEmail", aEmail));
        return (AccountEntity) cr.uniqueResult();
    }
}
