package com.modity.service;

import com.modity.dao.UserDao;
import com.modity.entity.User;
import com.modity.entity.UserInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/11/6.
 */
@Service("userService")
@Transactional(propagation = Propagation.REQUIRED)
public class UserService {

    @Resource(name="userDao")
    private UserDao userDao;

    //用户注册
    public User addUser(User user){
        return userDao.addUser(user);
    }

    //用户登陆
    public User doLogin(User user){
        String hql = "from User u where u.uname='"+user.getUname()+"'";
        List<User> list = userDao.findUserList(hql);
        if(list!=null&&list.size()>0){
            for (User users:list){
                if(users.getUname().equals(user.getUname())&&users.getUpwd().equals(user.getUpwd())){
                    return users;
                }
            }
        }
        return null;
    }

    //完善个人信息
    public boolean addUserData(UserInfo uinfo){
        //调用后台方法
        return userDao.addUserInfo(uinfo);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
