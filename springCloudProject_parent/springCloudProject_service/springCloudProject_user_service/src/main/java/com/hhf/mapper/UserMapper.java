package com.hhf.mapper;


import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.hhf.entity.User;

/**
 * extends BaseMapper<User>:使用MP插件
 */

//可不加注解、但是启动入门需扫包。
@Mapper
public interface UserMapper extends BaseMapper<User> {
	
	@Select("SELECT * FROM user WHERE yes=#{type}")
	List<User> findByType(@Param("type") Integer type);
}
