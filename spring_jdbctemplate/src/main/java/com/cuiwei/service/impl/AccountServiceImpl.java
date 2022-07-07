package com.cuiwei.service.impl;

import com.cuiwei.dao.AccountDao;
import com.cuiwei.domain.Account;
import com.cuiwei.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    public List<Account> finAll() {
        List<Account> list = accountDao.finAll();
        return list;
    }

    public Account findById(Integer id) {
        Account account = accountDao.findById(id);
        return account;
    }

    public void save(Account account) {
        accountDao.save(account);
    }

    public void update(Account account) {
        accountDao.update(account);
    }

    public void delete(Integer id) {
            accountDao.delete(id);
    }
}
