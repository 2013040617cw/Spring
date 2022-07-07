package com.cuiwei.dao;

public interface AccountDao {

    //转出
    public void out(String outUser,Double money);

    //转入
    public void in(String inUser,Double money);
}
