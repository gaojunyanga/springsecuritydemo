package com.glls.mysecuritydemo1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.glls.mysecuritydemo1.pojo.Menu;
import com.glls.mysecuritydemo1.pojo.Role;
import com.glls.mysecuritydemo1.pojo.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName : UsersMapper
 * @Author : glls
 * @Date: 2021/5/26 20:52
 * @Description :
 */
@Repository     // 这个注解的作用是注入的时候 不报红色警告
public interface UsersMapper extends BaseMapper<Users> {

    /**
     * 根据用户 Id 查询用户角色
     * @param userId
     * @return
     */
    List<Role> selectRoleByUserId(Integer userId);


    /**
     * 根据用户 Id 查询菜单
     * @param userId
     * @return
     */
    List<Menu> selectMenuByUserId(Integer userId);


}
