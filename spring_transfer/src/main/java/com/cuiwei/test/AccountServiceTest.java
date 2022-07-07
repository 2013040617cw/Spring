package com.cuiwei.test;

import com.cuiwei.proxy.CGlibProxyFactory;
import com.cuiwei.proxy.JDKProxyFactory;
import com.cuiwei.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class AccountServiceTest {

    @Autowired
    private JDKProxyFactory jdkProxyFactory;

    @Autowired
    private AccountService accountService;

    @Autowired
    private CGlibProxyFactory cGlibProxyFactory;

    @Test
    public void testTransfer(){

        accountService.transfer("tom","jerry",100d);

    }

    /**
     * JDK动态代理优化转账案例
     */
    @Test
    public void testTransferProxyJDK(){
        //当前返回的时AccountService的代理对象proxy
        AccountService accountServiceJDKProxy = jdkProxyFactory.createAccountServiceJDKProxy();
        //代理对象调用该接口的任意方法时都会执行底层的invoke方法
        accountServiceJDKProxy.transfer("tom","jerry",100d);



    }

    /**
     * 使用CGlib动态代理优化转账案例
     */
    @Test
    public void testTransferProxyCGlib(){
        AccountService accountService = cGlibProxyFactory.creatAccountServiceCglibFactory();
        accountService.transfer("tom","jerry",100d);


    }
}
