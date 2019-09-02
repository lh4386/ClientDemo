package com.example.demo.mapper;

import com.example.demo.entity.Hiredate;
import com.example.demo.entity.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface HiredateMapper {
    int deleteByPrimaryKey(Integer hid);

    int insert(Hiredate record);

    int insertSelective(Hiredate record);

    Hiredate selectByPrimaryKey(Integer hid);

    int updateByPrimaryKeySelective(Hiredate record);

    int updateByPrimaryKey(Hiredate record);

    List<UserVo> selectUser(Map map);
}