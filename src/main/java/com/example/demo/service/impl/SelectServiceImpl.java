package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SelectServiceImpl implements SelectService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUser(String usercode) {
        return userMapper.selectByPrimaryKey(usercode);
    }
}
