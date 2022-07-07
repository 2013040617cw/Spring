package com.cuiwei.test;

import com.cuiwei.dao.IUserDao;
import com.cuiwei.servic.IUserService;
import com.cuiwei.servic.impl.IUserServiceImpl;
import com.cuiwei.utils.BeanFactory;
import org.junit.Test;

public class SpringTest {
    @Test
    public void test01() throws  Exception{
        //获取业务层对象
        IUserService userService = new IUserServiceImpl();

        //调用save方法userService.save();

        userService.save();

    }

@Test
    public void test02() {

        IUserDao userDao = (IUserDao) BeanFactory.getBean("UserDao");

        userDao.save();
    }
}
