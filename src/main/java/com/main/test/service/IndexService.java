package com.main.test.service;

import com.main.test.entity.User;

import java.util.List;

public interface IndexService {
    public User selectOne(String name);

    List<User> selectAll(Integer page, Integer pageSize);
}
