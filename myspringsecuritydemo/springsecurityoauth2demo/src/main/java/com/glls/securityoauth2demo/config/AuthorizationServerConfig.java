package com.glls.securityoauth2demo.config;

import com.glls.securityoauth2demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

/**
 * @ClassName : AuthorizationServerConfig
 * @Author : glls
 * @Date: 2021/6/24 21:08
 * @Description :  授权服务器
 */
@Configuration
@EnableAuthorizationServer    // 开启授权服务器
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;



    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        //配置密码模式 需要的配置
        endpoints.authenticationManager(authenticationManager).userDetailsService(userService);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //这里是为了掩饰方便       下 面的参数 直接写死了
        clients.inMemory()
                //客户端id
                .withClient("client")
                //秘钥
                .secret(passwordEncoder.encode("123456"))
                //重定向地址
                .redirectUris("http://www.baidu.com")
                //授权范围
                .scopes("all")
                //授权类型   授权码模式   密码模式
                .authorizedGrantTypes("authorization_code","password");


    }
}
