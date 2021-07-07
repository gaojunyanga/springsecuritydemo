package com.glls.mysecuritydemo1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName : SecurityConfig
 * @Author : glls
 * @Date: 2021/5/26 20:08
 * @Description :
 */
@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter {


    //第二种
    //@Override
    //protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //    //用于密码的密文处理
    //    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    //    //生成密文
    //    String password = passwordEncoder.encode("123456");
    //    //设置用户名和密码
    //    auth.inMemoryAuthentication().withUser("qfAdmin").password(password).roles("admin");
    //}


    //第三种

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.logout().logoutUrl("/logout") //注销时访问的路径
                .logoutSuccessUrl("/login.html").permitAll(); //注销成功后访问的路径



        http.formLogin()
                .loginPage("/login.html") //设置自定义登陆页面 注意如果不通过controller 跳转这个页面需要放在static中
                .loginProcessingUrl("/usr/login") //登陆时访问的路径  这个路径表示表单提交
                .defaultSuccessUrl("/index").permitAll() //登陆成功后跳转的路径
                .and().authorizeRequests()
                .antMatchers("/","/user/login","/user/anno").permitAll() //设置可以直接访问的路径，取消拦截
                .anyRequest()   // 其他请求
                .authenticated()  //需要认证
                .and().csrf().disable(); //关闭csrf防护
    }





    // 注入 PasswordEncoder 类到 spring 容器中
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
