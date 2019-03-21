package com.itcast.test;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 陈佳杰
 * @version 1.0
 * @date 2019/3/20
 */
/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext*.xml",
                                 "classpath:spring-*.xml"})*/
public class PasswordTest {
    @Test
    public void testGetPassword(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123");
        System.out.println(encode);
        //$2a$10$xPuOiWHcuLP8S9lJO/E8VeaoRC6kWWQkuFX74Y5EE7H623yrZ96K.
    }
}
