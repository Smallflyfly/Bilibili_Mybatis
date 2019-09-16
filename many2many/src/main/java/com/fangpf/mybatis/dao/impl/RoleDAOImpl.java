package com.fangpf.mybatis.dao.impl;

import com.fangpf.mybatis.dao.RoleDAO;
import com.fangpf.mybatis.domain.Role;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-16 10:20
 */
public class RoleDAOImpl implements RoleDAO {


    private SqlSessionFactory factory;

    public RoleDAOImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Role> findAll() {
        SqlSession session = factory.openSession();
        List<Role> roles = session.selectList("com.fangpf.mybatis.dao.RoleDAO.findAll");
        return roles;
    }
}
