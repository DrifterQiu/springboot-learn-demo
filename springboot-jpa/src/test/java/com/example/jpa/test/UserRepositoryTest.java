package com.example.jpa.test;

import com.example.jpa.JpaApplication;
import com.example.jpa.entity.User;
import com.example.jpa.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.test.context.junit4.SpringRunner;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * @author qiuyu
 * @date 2022年08月18日 17:19
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes =  JpaApplication.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    public  void  testSaveUser() {
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

    @Test
    public void test() throws IOException {
        Resource resource = new ClassPathResource("test.properties");
        Properties properties = PropertiesLoaderUtils.loadProperties(resource);
        String a = null;
        a = properties.getProperty("dao.test");
        System.out.println(a);
    }



}