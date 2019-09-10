package com.fangpf.mybatis.mybatis.sqlsession;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-05 16:52
 */
public interface SqlSessionFactory {
    SqlSession openSession();
}
