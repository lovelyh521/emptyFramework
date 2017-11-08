package com.main.test.controller;

import com.github.pagehelper.PageInfo;
import com.main.test.JsonVo.ResultVo;
import com.main.test.entity.User;
import com.main.test.service.IndexService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

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
    @RequestMapping("/all/json")
    @ResponseBody
    public ResultVo allJson(@RequestParam(required = false, defaultValue = "1") Integer page, @RequestParam(name = "pageSize",defaultValue ="2") Integer pageSize){
        ResultVo resultVo = new ResultVo();
        List<User> users = indexService.selectAll(page,pageSize);
        PageInfo<User> countryPageInfo = new PageInfo<User>(users);
        resultVo.setData(users);
        resultVo.setPageInfo(countryPageInfo);
        resultVo.setStatus(1);
        return resultVo;
    }
}
