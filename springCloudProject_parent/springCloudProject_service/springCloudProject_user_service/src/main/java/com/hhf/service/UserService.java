package com.hhf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hhf.api.IUserService;
import com.hhf.entity.User;
import com.hhf.fegin.VipFeginService;
import com.hhf.mapper.UserMapper;

@RestController
public class UserService implements IUserService{
	
	@Autowired
	private VipFeginService vipFeginService;
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/getUserDataByType")
	public List<User> getUserDataByType(@RequestParam("type") Integer type) {
		return userMapper.findByType(type);
	}

	
	@RequestMapping("/getVipStrByFegin")
	public String vipFeginService(){
		return vipFeginService.getVipStr();
	}
	
}