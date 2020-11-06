package com.example.mybatisplus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplus.entity.User;
import com.example.mybatisplus.entity.UserVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserMapper extends BaseMapper<User> {

    @Select("select tu.* from tb_user tu INNER JOIN tb_user_coupon tuc on tu.id=tuc.user_id where tuc.user_id=#{userId}")
    List<UserVo> findUserVo(@Param("userId") String userId);

}
