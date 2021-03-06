package com.main.test.dao;

import com.main.test.entity.User;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {
    User selectByName(String name);
}