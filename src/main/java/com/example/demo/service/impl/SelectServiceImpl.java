package com.example.demo.service.impl;

import com.example.demo.entity.UserVo;
import com.example.demo.mapper.HiredateMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SelectServiceImpl implements SelectService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private HiredateMapper hiredateMapper;

    @Override
    public List<UserVo> selectUser(Map map) {
        return hiredateMapper.selectUser(map);
    }

    @Override
    public List<UserVo> selectUserAll() {
        return userMapper.selectAll();
    }

    @Override
    public int insert(UserVo userVo) {
        return userMapper.insert(userVo);
    }

}
