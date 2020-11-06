package com.example.mybatisplus;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.example.mybatisplus.dao.UserMapper;
import com.example.mybatisplus.entity.User;
import com.example.mybatisplus.entity.UserVo;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void insert(){
        User user=new User();
        user.setUsername("王震");
        user.setAge(26);
        user.setPassword("nicaia555");
        user.setPhone("15850225168");
        user.setCreated(LocalDateTime.now());
        int rows = userMapper.insert(user);
       System.out.println(rows);
    }


    @Test
    public void deleteById(){
        int rows = userMapper.deleteById(1324225121799823362L);
        System.out.println(rows);
    }

    @Test
    public void selectByList(){
        QueryWrapper<User> qw=new QueryWrapper<User>();

        qw.like("username","he").and(wq->wq.between("age",20,50)).select("username","age");
        List<Map<String, Object>> sdasd = userMapper.selectMaps(qw);
        sdasd.forEach(System.out::println);
    }




    @Test
    public void selectByMapper(){
        HashMap<String,Object> map=new HashMap<String,Object>(){
            {
                put("age","25");
                put("username","huge");
            }
        };

        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }


    @Test
    public void selectByWrapper(){
        QueryWrapper<User> qw=new QueryWrapper<User>();

        qw.like("username","he").and(wq->wq.between("age",20,50));
        List<User> users = userMapper.selectList(qw);
        users.forEach(System.out::println);
    }


    @Test
    public void update(){
        UpdateWrapper<User> uw =new UpdateWrapper<>();
        uw.eq("username","王震").or().between("age",20,30);
        User user =new User();
        user.setAge(30);

        int rows = userMapper.update(user,uw);
        System.out.println(rows);
    }


    @Test
    public void updateByChainWrapper(){
        boolean rows = new LambdaUpdateChainWrapper<User>(userMapper).eq(User::getUsername, "王震").set(User::getAge, 56).update();
        System.out.println(rows);

    }


    @Test
    public void selectByVo(){

        List<UserVo> userVo = userMapper.findUserVo("18");
        userVo.forEach(System.out::println);
    }

}
