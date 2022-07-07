package com.cuiwei.service.impl;

import com.cuiwei.dao.UserDao;
import com.cuiwei.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceimpl implements UserService {
    private UserDao userDao;


   /* //有参数构造
    public UserServiceimpl(UserDao userDao) {
        this.userDao = userDao;
    }
*/

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        //调用Dao层save方法
        userDao.save();

    }
}
