package com.example.jpa.controller;

import com.example.jpa.entity.User;
import com.example.jpa.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.HashMap;
import java.util.Map;


/**
 * @author qiuyu
 * @date 2022年08月05日 23:27
 */
@RestController
@RequestMapping("/jpa")
@Slf4j
public class UserController {

    //private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    UserRepository userRepository;

    /**
     * 新增
     * @param user
     * @return
     */
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody User user) {
        User user1 =  userRepository.save(user);
        return new  ResponseEntity(user1,HttpStatus.OK);
    }

    /**
     * 更新
     * @param user
     * @return
     */
    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody User user) {
        Integer updateNumber = userRepository.updateUser(user);
        Map<String,Boolean> map = new HashMap<>();
        if(updateNumber > 0) {
            map.put("flag",true);
            return new ResponseEntity<>(map, HttpStatus.OK);
        }else{
            map.put("flag",false);
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/find")
    public Page<User> getAllUserByPage(){
        //页数从0开始
        Pageable pageable = PageRequest.of(0,5,Sort.by(Sort.DEFAULT_DIRECTION,"id"));
        Specification<User> specification = (Specification<User>) (root,query,criteriaBuilder)->{
            Path password = root.get("password");
            Predicate p = criteriaBuilder.equal(password.as(String.class),"1234567");
            return p;
        };
        Page<User> userPage = userRepository.findAll(specification,pageable);
        log.info(String.valueOf(userPage.getTotalPages()));
        log.info(userPage.getContent().toString());
        return userPage;
    }



}
