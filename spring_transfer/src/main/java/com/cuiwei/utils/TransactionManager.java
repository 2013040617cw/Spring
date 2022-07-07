package com.cuiwei.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 事务管理器工具类    开启事务，提交事务，回滚事务，释放资源
 */
@Component
public class TransactionManager {

    @Autowired
    private  ConnectionUtils connectionUtils;
    /**
     * 开启事务
     */


    public void beginTransaction(){
        //获取一个Connection对象
        Connection connection = connectionUtils.getThreadConnection();
        try {
            //开启了一个手动事务，关闭了自动提交
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 提交事务
     */

    public void commit(){
        Connection connection = connectionUtils.getThreadConnection();
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */

    public void rollback(){
        Connection connection = connectionUtils.getThreadConnection();
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放资源
     */
    public void release(){

        //将手动事务，改回为自动提交事务
        Connection connection = connectionUtils.getThreadConnection();
        try {
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            //将连接归还到连接池
            connectionUtils.getThreadConnection().close();
            //解除线程绑定
            connectionUtils.removeThreadConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
