package com.example.jpa.test;

import com.example.jpa.JpaApplication;
import com.example.jpa.entity.User;
import com.example.jpa.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



import java.util.List;

/**
 * @author qiuyu
 * @date 2022年08月18日 17:19
 */

@SpringBootTest(classes =  JpaApplication.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser() {
        //User user = userRepository.save(User.builder().userName("jackxx").email("123456@126.com").password("1234").build());
        //Assert.assertNotNull(user);
        List<User> users= userRepository.findAll();
        System.out.println(users);
        Assert.assertNotNull(users);

    }

    @Test
    public void  deleteUserById(){
        int a = userRepository.deleteUserById(4);
        System.out.println(a);
    }

}
