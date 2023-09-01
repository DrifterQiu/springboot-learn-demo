package com.example.myBatis.controller;


import com.example.myBatis.dto.UserQo;
import com.example.myBatis.entity.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import com.example.myBatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 *
 * @author qiuyu
 * @date 2022年08月05日 23:27
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/findAll")
    public PageInfo<User> findAll(@RequestBody UserQo userQo){
        PageInfo<User> userPage = PageHelper.startPage(userQo.getPageNum(),userQo.getPageSize())
                .doSelectPageInfo(() -> userMapper.findAll());
        return userPage;
    }
}
