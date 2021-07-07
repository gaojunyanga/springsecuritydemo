package com.glls.springsecuritydemo3.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.glls.springsecuritydemo3.mapper.UsersMapper;
import com.glls.springsecuritydemo3.pojo.Menu;
import com.glls.springsecuritydemo3.pojo.Role;
import com.glls.springsecuritydemo3.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : MyUserDetailsService
 * @Author : glls
 * @Date: 2021/5/5 9:52
 * @Description :
 */
@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UsersMapper usersMapper;


    /**
     *
     * @author glls
     * @param username
     * @return org.springframework.security.core.userdetails.UserDetails
     * @date 2021/5/5 13:49
     *
     * 对于这个方法的理解    这个方法是根据用户名查询数据库  如果查到了 不代表认证成功
     *
     * 因为 还需要比较密码   而比较密码的操作 在这里是看不到的  所以 就算这个方法
     * 返回了一个 user 对象  也不代表 认证成功 ，还需要比较密码 比较密码的操作  security 帮助封装起来
     * 了 ，会拿这个方法的返回值  和  传过来的密码 进行比较   密码一致 则 认证成功
     * 所以  这个方法的返回结果 并不代表认证成功
     */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<Users> wrapper = new QueryWrapper();
        wrapper.eq("username",username);
        Users users = usersMapper.selectOne(wrapper);
        if(users == null) {
            throw new UsernameNotFoundException("用户名不存在！");
        }

        //查询 权限 和 角色  然后 封装到 User 中
        List<GrantedAuthority> auths = new ArrayList<>();
        //查询用户角色列表
        List<Role> roles = usersMapper.selectRoleByUserId(users.getId());
        //查询用户权限列表
        List<Menu> menus = usersMapper.selectMenuByUserId(users.getId());

        //处理角色  拼接   ROLE_xxx
        for(Role role: roles){
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_"+role.getName());
            auths.add(simpleGrantedAuthority);
        }
        //处理权限
        for(Menu menu:menus){
            auths.add(new SimpleGrantedAuthority(menu.getPermission()));
        }


        // 注意  new User(String username, String password, Collection<? extends GrantedAuthority> authorities)
        // 这第二个参数 是加密之后的 密码
        return new User(users.getUsername(), users.getPassword(),auths);

    }
}
