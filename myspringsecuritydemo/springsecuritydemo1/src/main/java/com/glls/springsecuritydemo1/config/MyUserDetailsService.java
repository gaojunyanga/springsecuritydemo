package com.glls.springsecuritydemo1.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName : LoginService
 * @Author : glls
 * @Date: 2021/5/4 20:13
 * @Description :
 */

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {


    // 根据 用户名 查询用户信息
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //设置角色，角色的概念在之后章节介绍
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("role");

        // 判断用户名是否存在
    /*    if (!"admin".equals(username)) {
            throw new UsernameNotFoundException("用户名不存在！");
        }*/


        // 从数据库中获取的密码 123456 的密文
        //String pwd =
        //        "$2a$10$mXydam1p7dcGGWWTfdUH..feST5wWPlMnXMV1t/7nZjTCWsSJrF1y";
// 第三个参数表示权限
        return new User("glls",new BCryptPasswordEncoder().encode("123456"),
                auths);
    }

}
