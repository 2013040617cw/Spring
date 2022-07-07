package com.cuiwei.service.impl;

import com.cuiwei.dao.AccountDao;
import com.cuiwei.service.AccountService;
import com.cuiwei.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private TransactionManager transactionManager;

    /**
     * 转账方法
     *
     * @param outUser
     * @param inUser
     * @param money
     */
    public void transfer(String outUser, String inUser, double money) {


        /**
         * 调用了减钱方法
         */
        accountDao.out(outUser, money);

        // int i = 1/0;

        /**
         * 加钱方法
         */
        accountDao.in(inUser, money);


    }
}
