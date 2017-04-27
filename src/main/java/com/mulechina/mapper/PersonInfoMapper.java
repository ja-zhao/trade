package com.mulechina.mapper;

import java.util.List;

import com.mulechina.domain.PersonInfo;

public interface PersonInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PersonInfo record);

    int insertSelective(PersonInfo record);

    List<PersonInfo> queryAll();
    
    PersonInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PersonInfo record);

    int updateByPrimaryKey(PersonInfo record);
}