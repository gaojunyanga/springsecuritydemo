package com.glls.springsecuritydemo3.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @ClassName : Menu
 * @Author : glls
 * @Date: 2021/5/5 15:24
 * @Description :
 */
@Data
@Alias("menu")
public class Menu {
    private Long id;
    private String name;
    private String url;
    private Long parentId;
    private String permission;
}
