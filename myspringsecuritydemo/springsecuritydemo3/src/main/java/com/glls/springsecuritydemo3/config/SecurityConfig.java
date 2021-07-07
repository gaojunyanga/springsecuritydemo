package com.glls.springsecuritydemo3.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

/**
 * @ClassName : SecurityConfig
 * @Author : glls
 * @Date: 2021/5/5 10:08
 * @Description :
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PersistentTokenRepository tokenRepository;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin()  // 自定义登录页面
                .loginPage("/login.html")  // 指定登录页面路径  如果直接是页面  必须在static中
                //.loginPage("/index")  // 指定登录页面路径  通过controller 跳转  则在templates 中
                .loginProcessingUrl("/login")
                //.successForwardUrl("/main")  // 登录页面表单的请求路径
                .defaultSuccessUrl("/main").permitAll() // 登陆成功之后 默认 跳转路径
                //.failureForwardUrl("/fail")    // 登录失败跳转到哪个url

                .usernameParameter("myusername")
                .passwordParameter("mypassword")
                .and()
                .authorizeRequests()
                .antMatchers("/layui/**","/user/anno") //表示配置请求路径
                .permitAll() // 指定 URL 无需保护。
                //1.hasAuthority方法：当前登陆用户，只有具有admin权限才可以访问这个路径
                //.antMatchers("/user/findAll").hasAuthority("menu:system")
                //2.hasAnyAuthority方法：当前登陆用户，具有admin或manager权限可以访问这个路径
                //.antMatchers("/user/findAll").hasAnyAuthority("menu:user")
                //3.hasRole方法：当前主体具有指定角色，则允许访问
                .antMatchers("/user/findAll").hasRole("管理员")
                //4.hasAnyRole方法：当前主体只要具备其中某一个角色就能访问
                //.antMatchers("/user/findAll").hasAnyRole("管理员,普通用户")
                .anyRequest() // 其他请求
                .authenticated() //需要认证
                .and().csrf().disable(); //关闭csrf防护  这个一定要加上

        http.exceptionHandling().accessDeniedPage("/unauth");

        // 开启记住我功能
        http.rememberMe()
                .tokenValiditySeconds(60)   // 单位是秒
                .tokenRepository(tokenRepository)
                .userDetailsService(userDetailsService);


        http.logout().logoutUrl("/logout") //注销时访问的路径
                .logoutSuccessUrl("/login.html").permitAll(); //注销成功后访问的路径

    }




    // 注入 PasswordEncoder 类到 spring 容器中
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
