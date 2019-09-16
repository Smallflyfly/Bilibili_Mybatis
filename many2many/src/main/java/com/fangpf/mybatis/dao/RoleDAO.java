package com.fangpf.mybatis.dao;

import com.fangpf.mybatis.domain.Role;

import java.util.List;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-16 10:18
 */
public interface RoleDAO {
    List<Role> findAll();
}
