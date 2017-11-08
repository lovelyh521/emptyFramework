package com.main.test.dao;

import com.main.test.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    User selectByName(String name);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}