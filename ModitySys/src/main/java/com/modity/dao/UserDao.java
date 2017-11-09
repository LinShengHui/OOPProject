package com.modity.dao;

import com.modity.entity.User;
import com.modity.entity.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/11/6.
 */
@Repository("userDao")
public class UserDao extends BaseDao {

    //添加一个用户，返回用户信息
    public User addUser(User user){
        return getSession().get(User.class, getSession().save(user));
    }

    //登陆方法
    public List findUserList(String hql){
        return getSession().createQuery(hql).list();
    }

    //添加 个人信息
    public boolean addUserInfo(UserInfo uinfo){
        getSession().save(uinfo);
        return true;
    }

}
