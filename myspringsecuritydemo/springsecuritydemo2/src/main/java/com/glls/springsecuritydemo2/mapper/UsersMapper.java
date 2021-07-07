package com.glls.springsecuritydemo2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.glls.springsecuritydemo2.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @ClassName : UsersMapper
 * @Author : glls
 * @Date: 2021/5/4 21:53
 * @Description :
 */
@Repository
public interface UsersMapper extends BaseMapper<Users> {
}
