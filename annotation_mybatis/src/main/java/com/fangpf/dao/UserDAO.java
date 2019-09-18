package com.fangpf.dao;

import com.fangpf.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-17 15:22
 */
public interface UserDAO {

    @Select("select * from user")
    List<User> findAll();

    @Insert("insert into user(username, address, sex, birthday) values (#{userName}, #{address}, #{sex}, #{birthday})")
    void saveUser(User user);

    @Delete("delete from user where id = #{id}")
    void DeleteUser(Integer id);

    @Select("select * from user where id = #{id}")
    User findById(Integer id);

    @Select("select * from user where userName like #{userName}")
    List<User> findByName(String userName);

    @Select("select count(*) from user")
    int findTotal();
}
