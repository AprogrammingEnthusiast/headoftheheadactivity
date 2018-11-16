package com.yiscn.service.impl;

import com.yiscn.model.ScUserDto;
import com.yiscn.service.IScUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScUserServiceImplTest {

    @Autowired
    private IScUserService scUserService;

    @Test
    public void get() {
    }

    @Test
    public void add() {

        ScUserDto scUserDto = new ScUserDto();
        scUserDto.setNickname("王茂平");
        scUserDto.setCity("成都");
        scUserDto.setGender(false);
        scUserDto.setHead("yyy.jpg");
        scUserDto.setOpenid("wangmaoping");
        Integer add = scUserService.add(scUserDto);
        System.out.println(add);
    }

    @Test
    public void update() {
    }
}