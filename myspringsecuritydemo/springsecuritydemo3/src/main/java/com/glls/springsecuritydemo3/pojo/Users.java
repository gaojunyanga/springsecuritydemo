package com.glls.springsecuritydemo3.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

/**
 * @ClassName : Users
 * @Author : glls
 * @Date: 2021/5/4 21:52
 * @Description :
 */

@Data
@Alias("users")
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    private Integer id;
    private String username;
    private String password;

}
