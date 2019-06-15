package com.zhou.ssm.service.impl;

import com.zhou.ssm.model.Tbladmin;
import com.zhou.ssm.dao.TbladminMapper;
import com.zhou.ssm.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Resource
    private TbladminMapper userDao;
    private Logger log = Logger.getLogger(UserServiceImpl.class);
    
    public List<Tbladmin> getAllUser() {
        return userDao.selectAll();
    }

    public String login(String username,String password){
        Tbladmin user;
        user = userDao.selectByPrimaryKey(username);
        if(user != null) {
            String psw = user.getUserpassword();
            log.info("id" + username);
            log.info("输入密码" + password);
            log.info("读取密码" + psw);

            if (psw.equals(password)) {
                log.info("登陆成功");
                return "success";
            } else {
                log.info("登陆失败");
                return "fail";
            }
        }else{
            log.info("用户名不存在");
            return "notexist";
        }
    }

    public int getRole(String username){
        Tbladmin user;
        user = userDao.selectByPrimaryKey(username);
        return user.getUserrole();
    }

    public int insert(Tbladmin t){
        return userDao.insert(t);
    }

    public int delete(String id){
        return userDao.deleteByPrimaryKey(id);
    }
}
