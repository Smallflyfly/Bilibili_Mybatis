package com.fangpf.dao;

import com.fangpf.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-18 10:54
 */
public interface AccountDAO {

    @Select("select * from account")
    @Results(id="accountMap", value = {
            @Result(id=true, column = "id", property = "id"),
            @Result(column = "uid", property = "uid"),
            @Result(column = "money", property = "money"),
            @Result(property = "user", column = "uid", one=@One(select="com.fangpf.dao.UserDAO.findById", fetchType = FetchType.EAGER))
    })
    List<Account> findAll();

    @Select("select * from account where uid = #{uid}")
    List<Account> findAccountById(Integer uid);
}
