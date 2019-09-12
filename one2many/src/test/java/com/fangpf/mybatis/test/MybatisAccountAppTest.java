package com.fangpf.mybatis.test;

import com.fangpf.mybatis.dao.AccountDAO;
import com.fangpf.mybatis.dao.impl.AccountDAOImpl;
import com.fangpf.mybatis.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.AccessibleObject;
import java.util.List;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-12 15:04
 */
public class MybatisAccountAppTest {

    private InputStream in = null;
    private AccountDAO accountDAO = null;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        accountDAO = new AccountDAOImpl(factory);
    }

    @After
    public void destory() throws IOException {
        in.close();
    }

    @Test
    public void testFindAllAccount(){
        List<Account> accounts = accountDAO.findAllAccount();
        for(Account account:accounts){
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }
}
