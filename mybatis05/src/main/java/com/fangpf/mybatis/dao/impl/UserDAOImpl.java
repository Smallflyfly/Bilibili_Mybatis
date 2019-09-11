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

    @Override
    public void saveUser(User user) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法
        session.insert("com.fangpf.mybatis.dao.UserDAO.saveUser", user);
        session.commit();
        session.close();
    }

    @Override
    public void update(User user) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法
        session.update("com.fangpf.mybatis.dao.UserDAO.update", user);
        session.commit();
        session.close();
    }

    @Override
    public void delete(Integer id) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法
        session.delete("com.fangpf.mybatis.dao.UserDAO.delete", id);
        session.commit();
        session.close();
    }

    @Override
    public User findByID(Integer id) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法
        User user = session.selectOne("com.fangpf.mybatis.dao.UserDAO.findByID", id);
        session.close();
        return user;
    }

    @Override
    public List<User> findByName(String username) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法
        List<User> users = session.selectList("com.fangpf.mybatis.dao.UserDAO.findByName", username);
        return users;
    }

    @Override
    public Integer countUsername() {
        Integer count = null;
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法
        count = session.selectOne("com.fangpf.mybatis.dao.UserDAO.countUsername");
        return count;
    }
}
