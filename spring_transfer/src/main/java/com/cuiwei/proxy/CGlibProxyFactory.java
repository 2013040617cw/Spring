package com.cuiwei.proxy;

import com.cuiwei.domain.Account;
import com.cuiwei.service.AccountService;
import com.cuiwei.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 该类类型就是采用CGlIB动态代理对目标类（AccountServiceImpl）进行方法transfer的动态增强（添加事务控制)
 */
public class CGlibProxyFactory {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionManager transactionManager;

    public AccountService creatAccountServiceCglibFactory() {
        //重写Cglib对应的API生成代理对象并进行返回
        //增强字节码
        //参数1：目标类的字节码对象
        //参数2：动作类，当代理对象调用目标对象的原方法时，那么会执行intercept方法
        final AccountService accountServiceProxy = (AccountService) Enhancer.create(accountService.getClass(), new MethodInterceptor() {
            // o:生成的代理对象
            //method:调用目标方法的引用
            //objects:方法入参
            //methodProxy: 代理方法
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

                try {
                  transactionManager.beginTransaction();
                    method.invoke(accountService, objects);
                    transactionManager.commit();
                } catch (Exception e) {
                    e.printStackTrace();
                    transactionManager.rollback();
                } finally {
                    transactionManager.release();
                }
                return null;
            }

        });
        return accountServiceProxy;


        }


}
