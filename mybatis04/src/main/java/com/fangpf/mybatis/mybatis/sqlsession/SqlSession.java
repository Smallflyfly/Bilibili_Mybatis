package com.fangpf.mybatis.mybatis.sqlsession;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-05 16:53
 */
public interface SqlSession {
    <T> T getMapper(Class<T> daoInterfaceClass);

    /**
     *释放资源
     * */
    void close();
}
