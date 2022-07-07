package com.cuiwei.factory;

import com.cuiwei.dao.UserDao;
import com.cuiwei.dao.impl.UserDaoimpl;

public class StaticFactoryBean {
    public static UserDao creatUserDao(){
        return new UserDaoimpl();
    }
}
