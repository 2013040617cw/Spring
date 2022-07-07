package com.cuiwei.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 连接工具类，从数据源中获取一个连接，并且将获取到的连接与线程进行绑定
 * ThreadLocal: 线程内部的存储类，可以在指定的线程内存储数据  key: ThreadLocal    value: 任意类型的值，在这存的就是Connection
 */
@Component
public class ConnectionUtils {

    @Autowired
    private DataSource dataSource;

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    /**
     * 获取当前线程上绑定的连接，如果获取到的连接为空，那么就要从数据源中获取连接，并且方到ThreadLocal中（绑定到当前线程）
     *
     * @return
     */
    public Connection getThreadConnection(){

        //先从ThreadLocal获取连接
        Connection connection = threadLocal.get();

        //判断线程中是否有Connection
        if(connection == null){
            //3.从数据源中获取一个连接，存到ThreadLocal中

            try {
                //不为Nnull
              connection = dataSource.getConnection();

                threadLocal.set(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;

    }


    /**
     * 解除线程的连接绑定
     */

    public void removeThreadConnection(){

        threadLocal.remove();
    }

}
