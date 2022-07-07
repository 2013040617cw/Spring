package com.cuiwei.service.impl;

import com.cuiwei.dao.AccountDao;
import com.cuiwei.domain.Account;
import com.cuiwei.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "accountService")   //相当于配置了bean标签  value相当于bean标签的id
@Scope("prototype")
public class AccountServiceImpl implements AccountService {

    @Autowired //根据数据类型注入
    private AccountDao accountDao;



    public List<Account> findAll() {

      return accountDao.findAll();
    }

    public Account findById(Integer id) {
        return accountDao.findById(id);
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
