package com.cuiwei.proxy;

import com.cuiwei.service.AccountService;

import com.cuiwei.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理工厂类
 *
 *
 */
@Component
public class JDKProxyFactory {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionManager transactionManager;

    /**
     * 采用JDK动态代理技术来生成目标类的代理对象
     *
     * ClassLoader loader:类加载器，帮助被代理对象获取到类加载器
     * Class  <?> interface被代理类所实现的全部接口
     * InvocationHandler h:当代理对象调用接口的任意方法时，那么都会去执行InvocationHandler中的invoke方法
     */

    public AccountService createAccountServiceJDKProxy(){

        AccountService accountServiceProxy = (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {

            //proxy当前代理对象的引用
            //method:被调用的目标方法的引用
            //args被调用目标方法的参数
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                try {
                    //手动开启事务，调用事务管理器类中的开启事务中的方法
                    transactionManager.beginTransaction();
                    method.invoke(accountService, args);
                    //手动的开启事务
                    transactionManager.commit();
                } catch (Exception e) {
                    e.printStackTrace();
                    //手动回滚事务
                    transactionManager.rollback();
                }finally {
                    //手动释放资源
                    transactionManager.release();
                }
                return null;
            }
        });

        return accountServiceProxy;

    }
}
