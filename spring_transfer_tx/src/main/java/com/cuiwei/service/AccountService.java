package com.cuiwei.service;

public interface AccountService {
    /**
     * 转账方法
     *
     */

    public void transfer(String outUser,String inUser,Double money);
}
