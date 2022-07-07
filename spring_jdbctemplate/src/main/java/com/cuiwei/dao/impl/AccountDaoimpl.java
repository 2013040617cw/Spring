package com.cuiwei.dao.impl;

import com.cuiwei.dao.AccountDao;
import com.cuiwei.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoimpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    /**
     * 查询所有账户
     * @return
     */
    public List<Account> finAll() {
        //需要用到JdbcTemplate
        String sql = "select * from account";
        List<Account> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Account>(Account.class));
        return list;

    }

    /**
     * 根据ID查询账户
     * @return
     */
    public Account findById(Integer id) {
        String sql = "select * from account where id = ?";
        Account account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Account>(Account.class), id);
        return account;
    }

    /**
     * 添加账户
     * @param account
     */

    public void save(Account account) {
        String sql = "insert into account values(null,?,?)";
        jdbcTemplate.update(sql,account.getName(),account.getMoney());
    }

    /**
     * 更新用户信息
     * @param account
     */
    public void update(Account account) {

        String sql = "update account set money = ? where name = ?";
        jdbcTemplate.update(sql,account.getMoney(),account.getName());
    }

    /**
     * 根据ID删除账户
     * @param id
     */
    public void delete(Integer id) {

        String sql = "delete from account where id = ?";
        jdbcTemplate.update(sql,id);
    }
}
