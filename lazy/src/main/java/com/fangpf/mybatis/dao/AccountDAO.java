package com.fangpf.mybatis.dao;

import com.fangpf.mybatis.domain.Account;

import java.util.List;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-12 14:55
 */
public interface AccountDAO {

    List<Account> findAllAccount();

    List<Account> findByUid(Integer uid);
}
