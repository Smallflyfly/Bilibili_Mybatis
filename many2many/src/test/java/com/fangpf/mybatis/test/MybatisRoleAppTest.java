package com.fangpf.mybatis.test;

import com.fangpf.mybatis.dao.RoleDAO;
import com.fangpf.mybatis.dao.impl.RoleDAOImpl;
import com.fangpf.mybatis.domain.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-12 15:04
 */
public class MybatisRoleAppTest {

    private InputStream in = null;
    private RoleDAO roleDAO = null;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        roleDAO = new RoleDAOImpl(factory);
    }

    @After
    public void destory() throws IOException {
        in.close();
    }

    @Test
    public void testFindAllRoles(){
        List<Role> roles = roleDAO.findAll();
        for(Role role:roles){
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }
}
