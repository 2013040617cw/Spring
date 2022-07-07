package com.cuiwei.test;

import com.cuiwei.domain.Account;
import com.cuiwei.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class AccountServiceTest {
    @Autowired
    private AccountService accountService;

    private Account account;


    /**
     * 测试添加
     */
    @Test
    public void testSave(){
        Account account = new Account();
        account.setName("cuiwei");
        account.setMoney(1200d);
        accountService.save(account);
    }


    /**
     * 测试查询
     *
     */
    @Test
    public void testSelect(){
        List<Account> list = accountService.finAll();
        for (Account account1 : list) {
            System.out.println(account1);
        }
    }


    /**
     * 根据ID进行查询
     */
    @Test
    public void testFindById(){
        Account account = accountService.findById(1);
        System.out.println(account);
    }

    /**
     * 测试刚更新
     */
    @Test
    public void testupdate(){
      Account account = new Account();
      account.setMoney(1500d);
      account.setName("cuiwei");
      accountService.update(account);
    }


    /**
     * 根据ID删除用户
     */
    @Test
    public void testdelete(){
        accountService.delete(4);
    }
}
