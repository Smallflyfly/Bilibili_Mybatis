package com.fangpf.mybatis.dao.impl;

import com.fangpf.mybatis.dao.AccountDAO;
import com.fangpf.mybatis.domain.Account;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-12 14:56
 */
public class AccountDAOImpl implements AccountDAO {

    private SqlSessionFactory factory;

    public AccountDAOImpl(SqlSessionFactory factory){
        this.factory = factory;
    }

    @Override
    public List<Account> findAllAccount() {
        SqlSession session = factory.openSession();
        List<Account> accounts = session.selectList("com.fangpf.mybatis.dao.AccountDAO.findAll");
        session.close();
        return accounts;
    }
}
