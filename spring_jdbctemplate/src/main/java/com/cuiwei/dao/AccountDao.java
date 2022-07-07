package com.cuiwei.dao;

import com.cuiwei.domain.Account;

import java.util.List;

public interface AccountDao {
    /**
     * 查询所有用户
     * @return
     */
    public List<Account> finAll();

    /**
     * 根据ID查询账户
     */
    public Account findById(Integer id);

    /**
     * 添加账户
     */
    public void save(Account account);


    /**
     * 更新账户
     */
    public void update(Account account);


    /**
     * 根据ID删除用户
     *
     */

    public void delete(Integer id);
}
