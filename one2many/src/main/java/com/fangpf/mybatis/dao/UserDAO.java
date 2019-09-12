package com.fangpf.mybatis.dao;

import com.fangpf.mybatis.domain.User;

import java.util.List;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-05 10:48
 */
public interface UserDAO {
    /**
     * 查询所有操作
     * */
    List<User> findAll();

    /**
     * 插入操作
     * */
    void saveUser(User user);

    /**
     * update
     * */
    void update(User user);

    /**
     * delete
     */
    void delete(Integer id);

    /**
     * find by id
     * */
    User findByID(Integer id);

    List<User> findByName(String username);

    Integer countUsername();
}
