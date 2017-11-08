package com.main.test.service.impl;

import com.github.pagehelper.PageHelper;
import com.main.test.dao.UserMapper;
import com.main.test.entity.User;
import com.main.test.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("IndexService")
public class IndexServiceImpl  implements IndexService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public User selectOne(String name){
        return userMapper.selectByName(name);
    }
    @Override
    public List<User> selectAll(Integer page,Integer pageSize){
        PageHelper.startPage(page, pageSize);
        return userMapper.selectAll();
    }
}
