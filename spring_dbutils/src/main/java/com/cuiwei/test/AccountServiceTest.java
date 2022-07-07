package com.cuiwei.test;

import com.cuiwei.domain.Account;
import com.cuiwei.service.AccountService;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountServiceTest {

    ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    AccountService accountService = (AccountService)classPathXmlApplicationContext.getBean("accountService");


    //测试添加
    @Test
    public void testsave(){
        Account account = new Account();
        account.setName("cuiwei");
        account.setMoney(888d);
        accountService.save(account);
    }


    //测试查询（根据ID擦查询）
    @Test
    public void testFindById(){
        Account account = accountService.findById(1);
        System.out.println(account);
    }

    //测试查询所有
    @Test
    public void testfindAll(){
        List<Account> all = accountService.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
    }

    //测试更新
    @Test
    public void update(){
        Account account = new Account();
        account.setId(3);
        account.setName("lihuikang");
        account.setMoney(400d);
        accountService.update(account);
    }


    //测试删除
    @Test
    public void delete(){
        accountService.delete(3);
    }

}
