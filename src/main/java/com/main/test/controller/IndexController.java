package com.main.test.controller;

import com.main.test.entity.User;
import com.main.test.service.IndexService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class IndexController {

    @Resource(name="IndexService")
    private IndexService indexService;
    @RequestMapping("/hello")
    public String  index(String name, Model model){
        User user = indexService.selectOne(name);
        System.out.println("user = " + user);
        model.addAttribute("user",user);
        return "index";
    }
    @RequestMapping("/hello/json")
    @ResponseBody
    public User  indexJson(String name){
        User user = indexService.selectOne(name);
        System.out.println("user = " + user);
        return user;
    }
}
