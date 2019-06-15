package com.zhou.ssm.service;

import com.zhou.ssm.model.Tbladmin;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    List<Tbladmin> getAllUser();
    //用户登录
    String login(String username, String password);
    int getRole(String username);
    int insert(Tbladmin t);
    int delete(String id);

}
