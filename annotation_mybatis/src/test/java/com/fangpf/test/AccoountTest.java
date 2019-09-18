package com.fangpf.test;

import com.fangpf.dao.AccountDAO;
import com.fangpf.dao.UserDAO;
import com.fangpf.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-18 10:55
 */
public class AccoountTest {

    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private AccountDAO accountDAO;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        accountDAO =  session.getMapper(AccountDAO.class);
    }

    @After
    public void destroy() throws IOException {
        session.close();
        in.close();
    }

    @Test
    public void findAll(){
        List<Account> accounts = accountDAO.findAll();
        for (Account account:accounts){
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    @Test
    public void findAccountById(){
        List<Account> accounts = accountDAO.findAccountById(2);
        for (Account account:accounts){
            System.out.println(account);
        }
    }
}
