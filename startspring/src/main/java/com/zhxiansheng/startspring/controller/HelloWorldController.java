package com.zhxiansheng.startspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author ZhengH
 * @Date 2019/11/20 22:16
 **/
@Controller
public class HelloWorldController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }


    @PostMapping("/user/login")
    public String login(@RequestParam(name="username") String userName,
                        @RequestParam(name="password") String passWord,
                        Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(userName) && "123456".equals(passWord)){
            //登陆成功，防止表单重复提交，可以重定向到主页
            session.setAttribute("loginUser",userName);
            return "redirect:/main.html";
        }else{
            //登陆失败
            map.put("msg","用户名密码错误");
            return  "login";
        }
    }

}
