package com.main.test.service.impl;

import com.main.test.dao.UserMapper;
import com.main.test.entity.User;
import com.main.test.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("IndexService")
public class IndexServiceImpl  implements IndexService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public User selectOne(String name){
        return userMapper.selectByName(name);
    }
}
