package com.fanqie.three.jpa;

import com.fanqie.three.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/10/9.
 */
public interface UserJPA extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity>, Serializable {

    UserEntity findFirstByName(String name);
}
