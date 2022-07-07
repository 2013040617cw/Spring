package com.cuiwei.service.imol;

import com.cuiwei.dao.AccountDao;
import com.cuiwei.service.AccountService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    /**
     * 转账方法
     * @param outUser
     * @param inUser
     * @param money
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,timeout = -1,readOnly = false)
    public void transfer(String outUser, String inUser, Double money) {
        /**
         * 调用Dao层的out和in方法
         */
        accountDao.out(outUser,money);

        /*int i = 1/0;*/
          accountDao.in(inUser,money);
    }
}
