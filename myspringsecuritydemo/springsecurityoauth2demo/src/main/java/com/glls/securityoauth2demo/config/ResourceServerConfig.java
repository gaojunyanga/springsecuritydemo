package com.glls.securityoauth2demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @ClassName : ResourceServerConfig
 * @Author : glls
 * @Date: 2021/6/28 19:35
 * @Description :   资源服务器
 *
 * 这里是为了方便  把授权服务器和资源服务器放在了一起   正式环境下  二者是在不同的服务器
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {




    //这个方法跟 SecurityConfig 中的方法一样
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .requestMatchers()
                .antMatchers("/user/**");   //配置需要保护的资源路径
    }
}
