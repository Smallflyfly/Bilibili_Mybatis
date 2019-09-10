package com.fangpf.mybatis.test;

import com.fangpf.mybatis.DAO.UserDAO;
import com.fangpf.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-05 10:30
 */
public class MybatisAppTest {
    public static void main(String[] args) throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session = null;
        session = factory.openSession();
        //4.使用SqlSession创建DAO接口的代理对象
        UserDAO userDAO = session.getMapper(UserDAO.class);
        //5.使用代理对象执行方法
        List<User> users = userDAO.findAll();
        for(User user:users){
            System.out.println(user);
        }
        //6.释放对象
        session.close();
        in.close();
    }
}
