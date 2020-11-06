package com.example.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@TableName("tb_user")
public class User {

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


}
