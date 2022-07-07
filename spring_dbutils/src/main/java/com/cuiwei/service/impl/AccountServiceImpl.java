package com.cuiwei.service.impl;

import com.cuiwei.dao.AccountDao;
import com.cuiwei.domain.Account;
import com.cuiwei.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "accountService")   //相当于配置了bean标签  value相当于bean标签的id
@Scope("prototype")
public class AccountServiceImpl implements AccountService {

    @Autowired //根据数据类型注入
    private AccountDao accountDao;

    @Value("注入普通属性")  //注入普通属性的值
    private String str;

    @Value("${jdbc.driverClassName}")
    private String driver;

    /*public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
*/

    public void init(){
        System.out.println("初始化方法。。。。");
    }


    public void destory(){
        System.out.println();
    }

    public List<Account> findAll() {
        System.out.println(str);
        System.out.println(driver);
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
