package com.fangpf.mybatis.dao.impl;

import com.fangpf.mybatis.dao.UserDAO;
import com.fangpf.mybatis.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-11 10:45
 */
public class UserDAOImpl implements UserDAO {

    private SqlSessionFactory factory;

    public UserDAOImpl(SqlSessionFactory factory){
        this.factory = factory;
    }

    @Override
    public List<User> findAll() {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法
        List<User> users = session.selectList("com.fangpf.mybatis.dao.UserDAO.findAll");
        session.close();
        return users;
    }
}
