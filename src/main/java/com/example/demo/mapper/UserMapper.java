package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(String usercode);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String usercode);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}