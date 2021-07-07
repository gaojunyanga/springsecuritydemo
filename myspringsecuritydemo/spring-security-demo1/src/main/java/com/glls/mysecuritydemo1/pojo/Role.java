package com.glls.mysecuritydemo1.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @ClassName : Role
 * @Author : glls
 * @Date: 2021/5/26 20:56
 * @Description :
 */
@Data
@Alias("role")
public class Role {
    private Long id;
    private String name;
}
