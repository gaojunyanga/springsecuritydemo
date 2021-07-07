package com.glls.mysecuritydemo1.security;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.glls.mysecuritydemo1.mapper.RoleMapper;
import com.glls.mysecuritydemo1.mapper.UsersMapper;
import com.glls.mysecuritydemo1.pojo.Role;
import com.glls.mysecuritydemo1.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName : MyUserDetailsService
 * @Author : glls
 * @Date: 2021/5/26 20:09
 * @Description :  第三种
 */
@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private RoleMapper roleMapper;
   // @Override
   // public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 判断用户名是否存在
        //if (!"admin".equals(username)) {
        //    throw new UsernameNotFoundException("用户名不存在！");
        //}


        // 从数据库中获取的密码 123456 的密文
        //String pwd =
        //        "$2a$10$mXydam1p7dcGGWWTfdUH..feST5wWPlMnXMV1t/7nZjTCWsSJrF1y";
// 第三个参数表示权限
        //return new User("glls",pwd,
        //        AuthorityUtils.commaSeparatedStringToAuthorityList("admin,"));
    //}





    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        LambdaQueryWrapper<Users> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Users::getUsername,username);
        Users users = usersMapper.selectOne(wrapper);
        if(users == null) {
            throw new UsernameNotFoundException("用户名不存在！");
        }
        System.out.println(users);

        List<Role> roles = usersMapper.selectRoleByUserId(users.getId());
        List<String> collectRoleNames = roles.stream().map(role -> {
            return role.getName();
        }).collect(Collectors.toList());

        //List<GrantedAuthority> auths =
        //        AuthorityUtils.commaSeparatedStringToAuthorityList("role");

        List<GrantedAuthority> authorityList = AuthorityUtils.createAuthorityList(collectRoleNames.toArray(new String[collectRoleNames.size()]));
        return new User(users.getUsername(),users.getPassword(),authorityList);

    }
}
