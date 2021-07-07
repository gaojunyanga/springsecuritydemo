package com.glls.springsecuritydemo3.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.glls.springsecuritydemo3.pojo.Menu;
import com.glls.springsecuritydemo3.pojo.Role;
import com.glls.springsecuritydemo3.pojo.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName : UsersMapper
 * @Author : glls
 * @Date: 2021/5/4 21:53
 * @Description :
 */
@Repository
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
