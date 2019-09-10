package com.fangpf.mybatis.test;

import com.fangpf.mybatis.dao.UserDAO;
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
    private SqlSession sqlSession = null;
    private UserDAO userDAO = null;

    @Before //用于测试方法执行之前
    public void init() throws IOException {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
//        //3.使用工厂创建dao对象
//        UserDAO userDAO = new UserDAOImpl(factory);
        sqlSession = factory.openSession();
        //4.获取dao代理对象
        userDAO = sqlSession.getMapper(UserDAO.class);
    }

    @After
    public void destory() throws IOException {
        sqlSession.commit();
        //6.释放对象
        in.close();
        sqlSession.close();
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
        user.setUsername("小雷");
        user.setSex("男");
        user.setAddress("四川成都");
        user.setBirthday(new Date());
        //执行插入方法
        userDAO.saveUser(user);
        //提交事务
//        sqlSession.commit();
    }

    @Test
    public void update(){
        User user = new User();
        user.setId(9);
        user.setUsername("小澜");
        user.setSex("女");
        user.setAddress("山西太原");
        user.setBirthday(new Date());
        //执行插入方法
        userDAO.update(user);
//        sqlSession.commit();
    }

    @Test
    public void delete(){
        userDAO.delete(6);
    }

    @Test
    public void findByID(){
       User user =  userDAO.findByID(7);
        System.out.println(user);
    }

    @Test
    public void findByName(){
        List<User> userList = userDAO.findByName("%小%");
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
