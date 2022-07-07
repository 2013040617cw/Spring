package com.cuiwei.servic.impl;

import com.cuiwei.dao.IUserDao;
import com.cuiwei.dao.impl.IUserDaoImpl;
import com.cuiwei.servic.IUserService;
import com.cuiwei.utils.BeanFactory;

import java.io.IOException;

public class IUserServiceImpl implements IUserService {
    public void save() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //调用DAO层代码  传统方式  存在编译期依赖，耦合重
        //IUserDao userDao = new IUserDaoImpl();

        //反射  存在硬编码
        //IUserDao userDao =(IUserDao) Class.forName("com.cuiwei.dao.impl.IUserDaoImpl").newInstance();

        IUserDao userDao = (IUserDao) BeanFactory.getBean("UserDao");
        userDao.save();




    }
}
