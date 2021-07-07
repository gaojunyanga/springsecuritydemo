package com.glls.springsecuritydemo3.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @ClassName : Role
 * @Author : glls
 * @Date: 2021/5/5 15:25
 * @Description :
 */
@Data
@Alias("role")
public class Role {
    private Long id;
    private String name;
}
