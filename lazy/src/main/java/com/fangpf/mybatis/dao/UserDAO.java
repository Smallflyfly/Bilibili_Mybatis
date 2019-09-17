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
     * 查询所有操作  同时获取到用户下所有账户信息
     * */
    List<User> findAll();
    User findById(Integer id);

}
