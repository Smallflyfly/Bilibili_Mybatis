package com.fangpf.mybatis.test;

import com.fangpf.mybatis.dao.UserDAO;
import com.fangpf.mybatis.dao.impl.UserDAOImpl;
import com.fangpf.mybatis.domain.User;
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
 * @date 2019-09-05 10:30
 */
public class MybatisAppTest {

    private InputStream in = null;
//    private SqlSession sqlSession = null;
    private UserDAO userDAO = null;

    @Before //用于测试方法执行之前
    public void init() throws IOException {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
//        //3.使用工厂创建dao对象
        userDAO = new UserDAOImpl(factory);
    }

    @After
    public void destory() throws IOException {
//        sqlSession.commit();
        //6.释放对象
        in.close();
//        sqlSession.close();
    }

    @Test
    public void testFindAll() throws Exception{
        //5.执行查询方法
        List<User> users = userDAO.findAll();
        for(User user:users){
            System.out.println(user);
        }
    }

    @Test
    public void testSave() throws IOException {
        User user = new User();
        user.setUsername("小木");
        user.setSex("男");
        user.setAddress("河南信阳");
        user.setBirthday(new Date());
        //执行插入方法
        userDAO.saveUser(user);
        //提交事务
//        sqlSession.commit();
    }

    @Test
    public void update(){
        User user = new User();
        user.setId(11);
        user.setUsername("小飞");
        user.setSex("男");
        user.setAddress("山西运城");
        user.setBirthday(new Date());
        //执行插入方法
        userDAO.update(user);
//        sqlSession.commit();
    }

    @Test
    public void delete(){
        userDAO.delete(10);
    }

    @Test
    public void findByID(){
       User user =  userDAO.findByID(4);
        System.out.println(user);
    }

    @Test
    public void findByName(){
        List<User> userList = userDAO.findByName("%黑%");
        for(User user:userList){
            System.out.println(user);
        }
    }

    @Test
    public void countUsername(){
        Integer count = userDAO.countUsername();
        System.out.println(count);
    }
}
