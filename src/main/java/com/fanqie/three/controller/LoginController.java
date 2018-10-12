package com.fanqie.three.controller;

import com.fanqie.three.entity.UserEntity;
import com.fanqie.three.jpa.UserJPA;
import com.fanqie.three.util.CommonSpecUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2018/10/9.
 */
@RestController
@RequestMapping(value = "/user")
public class LoginController {

    @Resource
    private UserJPA userJPA;

    @Autowired
    private CommonSpecUtil<UserEntity> userEntityCommonSpecUtil;

    @GetMapping("/login")
    public String login(UserEntity user, HttpServletRequest request) {
        //登录成功
        boolean flag = true;
        String result = "登录成功";

        //根据用户名查询用户是否存在

        // 方法一
        // UserEntity userEntity = userJPA.findFirstByName(user.getName());

        // 方法二
        Specification<UserEntity> spec = Specification.where(
                userEntityCommonSpecUtil.equal("name", user.getName()));
        List<UserEntity> userEntities = userJPA.findAll(spec);
        UserEntity userEntity = CollectionUtils.isEmpty(userEntities) ? null : userEntities.get(0);

        //用户不存在
        if (userEntity == null) {
            flag = false;
            result = "用户不存在，登录失败";
        } else if (!userEntity.getPwd().equals(user.getPwd())) {
            //密码错误
            flag = false;
            result = "用户密码不相符，登录失败";
        }
        //登录成功
        if (flag) {
            //将用户写入session
            request.getSession().setAttribute("_session_user", userEntity);
        }
        return result;
    }
}
