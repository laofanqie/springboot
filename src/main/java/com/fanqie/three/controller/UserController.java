package com.fanqie.three.controller;

import com.fanqie.three.entity.UserEntity;
import com.fanqie.three.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2018/10/9.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserJPA userJPA;

    @GetMapping("/list")
    public List<UserEntity> list() {
        return userJPA.findAll();
    }

    @PostMapping("/save")
    public UserEntity save(UserEntity entity) {
        return userJPA.save(entity);
    }

    @DeleteMapping("/delete")
    public List<UserEntity> delete(Long id) {
        userJPA.deleteById(id);
        return userJPA.findAll();
    }
}
