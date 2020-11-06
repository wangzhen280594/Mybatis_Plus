package com.example.mybatisplus.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserVo  extends User{
    //主键
    private Long id;
    //用户名
    private String username;
    //密码
    private String password;
    //手机号
    private String phone;
    //创建时间
    private LocalDateTime created;
    //年龄
    private Integer  age;

    private String  status;
}
