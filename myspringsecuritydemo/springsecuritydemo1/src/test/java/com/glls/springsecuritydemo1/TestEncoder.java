package com.glls.springsecuritydemo1;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ClassName : TestEncoder
 * @Author : glls
 * @Date: 2021/5/4 18:25
 * @Description :
 */
public class TestEncoder {
    @Test
    public void test01(){
// 创建密码解析器
        BCryptPasswordEncoder bCryptPasswordEncoder = new
                BCryptPasswordEncoder();
// 对密码进行加密
        String pass = bCryptPasswordEncoder.encode("1234567");
// 打印加密之后的数据
        System.out.println("加密之后数据：\t"+pass);
//判断原字符加密后和加密之前是否匹配
        boolean result = bCryptPasswordEncoder.matches("1234567", pass);
// 打印比较结果
        System.out.println("比较结果：\t"+result);
    }
}
