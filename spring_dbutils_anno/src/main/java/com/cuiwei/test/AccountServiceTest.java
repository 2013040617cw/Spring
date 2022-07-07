package com.cuiwei.test;

import com.cuiwei.config.springConfig;
import com.cuiwei.domain.Account;
import com.cuiwei.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class) //@RunWith是指定的junit运行环境，SpringJUnit4ClassRunner是Spring提供的作为junit运行环境的一个类
@ContextConfiguration(classes = {springConfig.class})
public class AccountServiceTest {

   // ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    //AccountService accountService = (AccountService)classPathXmlApplicationContext.getBean("accountService");

   /* //当前改成了纯注解形式
    AnnotationConfigApplicationContext configApplicationContext =  new AnnotationConfigApplicationContext(springConfig.class);
    AccountService accountService = (AccountService) configApplicationContext.getBean("accountService");*/

   @Autowired
   private AccountService accountService;

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



    //测试纯注解
    public void test(){
        AnnotationConfigApplicationContext configApplicationContext =  new AnnotationConfigApplicationContext(springConfig.class);
        AccountService accountService = (AccountService) configApplicationContext.getBean("accountService");
    }

}
