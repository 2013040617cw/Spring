package com.cuiwei.dao.impl;

import com.cuiwei.dao.IUserDao;
import jdk.swing.interop.SwingInterOpUtils;

public class IUserDaoImpl implements IUserDao {
    public void save() {
        System.out.println("dao被调用了，保存成功");
    }
}
