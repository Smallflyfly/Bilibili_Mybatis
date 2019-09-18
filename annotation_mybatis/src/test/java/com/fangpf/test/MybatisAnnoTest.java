package com.fangpf.test;

import com.fangpf.dao.UserDAO;
import com.fangpf.domain.Account;
import com.fangpf.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-17 16:23
 */
public class MybatisAnnoTest {

    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private UserDAO userDAO;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        userDAO = session.getMapper(UserDAO.class);
    }

    @After
    public void destroy() throws IOException {
        session.close();
        in.close();
    }

    @Test
    public void findAll() throws IOException {
        List<User> users = userDAO.findAll();
        for(User user:users){
            System.out.println(user);
            System.out.println(user.getAccounts());
        }

        session.close();
        in.close();
    }

    @Test
    public void insertUser(){
        User user = new User();
        user.setUserName("小林");
        user.setAddress("上海");
        user.setSex("男");
        user.setBirthday(new Date(1988-3-25));
        userDAO.saveUser(user);
        session.commit();
    }

    @Test
    public void deleteUser(){
        userDAO.DeleteUser(12);
        session.commit();
    }

    @Test
    public void findById(){
        User user = userDAO.findById(9);
        System.out.println(user);
    }

    @Test
    public void findByName(){
        List<User> users = userDAO.findByName("%小%");
        for(User user:users){
            System.out.println(user);
        }
    }

    @Test
    public void findTotal(){
        int total = userDAO.findTotal();
        System.out.println(total);
    }
}
