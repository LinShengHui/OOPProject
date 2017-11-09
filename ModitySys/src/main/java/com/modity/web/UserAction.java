package com.modity.web;

import com.modity.entity.User;
import com.modity.entity.UserInfo;
import com.modity.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * user控制层
 * Created by Administrator on 2017/11/6.
 */
@Controller
@RequestMapping("/userAction")
@Scope("prototype")
public class UserAction {

    @Resource(name="userService")
    private UserService userService;

    //用户注册
    @RequestMapping("/addUser")
    public String addUser(User user,  HttpSession session ){
        user = userService.addUser(user);
        session.setAttribute("userInfo",user);
        //调用服务层方法
        return "redirect:/userData.jsp";
    }

    //用户登陆
    @RequestMapping("/userLogin")
    public String doLogin(User user, HttpSession session,Model model){
        user = userService.doLogin(user);
        if(user==null){
            model.addAttribute("message","密码错误！");
            return "redirect:/index.jsp";
        }else{
            session.setAttribute("loginName",user.getUname());
            return "redirect:/main.jsp";
        }
    }

    //完善用户信息
    @RequestMapping("/addUserInfo")
    public String addUserInfo(MultipartFile ufile, UserInfo uinfo, Model model, HttpSession session){
        System.out.println(uinfo.getIname());

        if(!ufile.isEmpty()){
            //获取服务器路径
            String basePath=session.getServletContext().getRealPath("/images");
            String realName=ufile.getOriginalFilename();//真实上传的文件名
            try {
                ufile.transferTo(new File(basePath+"/"+realName));
                uinfo.setIurl(realName);
            } catch (IOException e) {
                e.printStackTrace();
                return "error";
            }
        }else{
            uinfo.setIurl("");
        }

        //调用服务层方法进行数据添加完善个人信息
        if(userService.addUserData(uinfo)){
            session.setAttribute("userName",uinfo.getIname());
            return "redirect:/main.jsp";
        }else{
            model.addAttribute("message","完善个人信息失败！");
            return "redirect:/index.jsp";
        }
    }

}
