package com.fangpf.mybatis.mybatis.io;

import com.sun.xml.internal.ws.util.ReadAllStream;

import java.io.InputStream;

/**
 * @author fangpf
 * @version 1.0
 * @date 2019-09-05 16:36
 * 使用类加载器读取配置文件类
 */
public class Resources {
    /**
     * 根据传入参数，获取一个字节输入流
     * */
    public static InputStream getResourceAsStream(String filePath){
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
