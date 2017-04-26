package com.mulechina.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.mulechina.domain.User;

/**
 * Created by Administrator on 2016/9/2.
 */
@Mapper
public interface UserMapper {
	@Select("select * from user where username = #{username}")
	User findUserByUsername(@Param("username") String username);
	
	@Select("select count(*) from user where username = #{username} and password=#{password}")
	int checklogin(User user);
}