package com.example.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.ws.BindingType;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo{
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
