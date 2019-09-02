package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.entity.UserVo;

import java.util.List;
import java.util.Map;

public interface SelectService {

    List selectUser(Map map);
    List<UserVo> selectUserAll();
    int insert(UserVo userVo);

}
