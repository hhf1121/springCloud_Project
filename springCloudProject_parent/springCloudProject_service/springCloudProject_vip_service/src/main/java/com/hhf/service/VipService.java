package com.hhf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hhf.api.IVipService;
import com.hhf.entity.User;
import com.hhf.fegin.UserFeginService;


@RestController
public class VipService implements IVipService{
	
	@Autowired
	private UserFeginService userFegin;
	
	@RequestMapping("/getVipStr")
	public String getVipStr() {
		return "调用vip接口：getVipStr";
	}

	@RequestMapping("/getUserByFegin")
	public List<User> getUserByFegin(Integer type) {
		return userFegin.getUserDataByType(type);
	}
	
	@RequestMapping("/getUserByTime")
	public String getUserDataTimeOut(Integer times) {
		return userFegin.getUserDataTimeOut(times);
	}

}
