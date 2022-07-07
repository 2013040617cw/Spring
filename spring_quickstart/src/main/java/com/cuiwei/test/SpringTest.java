package com.cuiwei.test;

import com.cuiwei.dao.UserDao;
import com.cuiwei.service.UserService;
import com.cuiwei.service.impl.UserServiceimpl;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class SpringTest {

    @Test
    public void tese01(){

        //获取到了Spring上下文对象，能够以获取到IOC容器中的bean对象
       ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");


       //使用上下文对象从IOC容器中获取到了bean对象
       UserDao userDao = (UserDao) classPathXmlApplicationContext.getBean("userDao");

       //调用方法
       userDao.save();

    }

@Test
    public  void test02(){
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));

       UserDao userDao = (UserDao) xmlBeanFactory.getBean("userDao");

       userDao.save();

    }


    /**
     * 测试单例(地址相等则单例)
     */
    @Test
    public void tese03(){

        //获取到了Spring上下文对象，能够以获取到IOC容器中的bean对象
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");


        //使用上下文对象从IOC容器中获取到了bean对象
        UserDao userDao = (UserDao) classPathXmlApplicationContext.getBean("userDao");

        UserDao userDao2 = (UserDao) classPathXmlApplicationContext.getBean("userDao");

        System.out.println(userDao);

        System.out.println(userDao2);

        classPathXmlApplicationContext.close();

    }


    @Test
    public void test4(){
      /*  UserService userService = new UserServiceimpl();
        userService.save();*/

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userService = (UserService) classPathXmlApplicationContext.getBean("userService");

        userService.save();




    }

    @Test
    public void test5(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) classPathXmlApplicationContext.getBean("userService");
        userService.save();
    }

}
