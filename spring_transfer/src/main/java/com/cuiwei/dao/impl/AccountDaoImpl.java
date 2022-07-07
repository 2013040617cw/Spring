package com.cuiwei.dao.impl;

import com.cuiwei.dao.AccountDao;
import com.cuiwei.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository("accountDao") //生成该类的实例存在IOC容器中
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private QueryRunner queryRunner;

    @Autowired
    private ConnectionUtils connectionUtils;

    /**
     * 转出操作
     * @param outUser
     * @param money
     */
    public void out(String outUser, Double money) {

        String sql = "update account set money = money - ? where name = ?";

        try {
            queryRunner.update(connectionUtils.getThreadConnection(),sql,money,outUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    /**
     * 转入操作
     * @param inUser
     * @param money
     */
    public void in(String inUser, Double money) {

        String sql = "update account set money = money + ? where name = ?";
        try {
            queryRunner.update(connectionUtils.getThreadConnection(),sql,money,inUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
