package com.fangpf.dao;

import com.fangpf.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-17 15:22
 */
public interface UserDAO {

    @Select("select * from user")
    @Results(id = "userMap", value = {
            @Result(id=true, column = "id", property = "id"),
            @Result(column = "userName", property = "userName"),
            @Result(column = "address", property = "address"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "birthday", property = "birthday"),
            @Result(property = "accounts", column = "id", many = @Many(select = "com.fangpf.dao.AccountDAO.findAccountById", fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    @Insert("insert into user(username, address, sex, birthday) values (#{userName}, #{address}, #{sex}, #{birthday})")
    void saveUser(User user);

    @Delete("delete from user where id = #{id}")
    void DeleteUser(Integer id);

    @Select("select * from user where id = #{id}")
    @ResultMap(value = {"userMap"})
    User findById(Integer id);

    @Select("select * from user where userName like #{userName}")
    List<User> findByName(String userName);

    @Select("select count(*) from user")
    int findTotal();
}
