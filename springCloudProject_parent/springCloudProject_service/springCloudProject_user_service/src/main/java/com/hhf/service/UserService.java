package com.hhf.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import com.hhf.api.IUserService;
import com.hhf.entity.User;
import com.hhf.fegin.VipFeginService;
import com.hhf.mapper.UserMapper;

@RestController
public class UserService implements IUserService{
	
	@Value("${server.port}")
	private String port;
	
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
	
	@RequestMapping("/getUserDataTimeOut")
	public String getUserDataTimeOut(@RequestParam("times") Integer times){
		try {
			Thread.sleep(times);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "vip调用user-getUserDataTimeOut：time："+times;
	}

	@RequestMapping("/getUserStr")
	public String getUserStr() {
		return "user：getUserStr被调用。。。"+port;
	}

	@Override
	public String getUserTimeOut(Integer times) {
		try {
			Thread.sleep(times);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "vip调用user-getUserTimeOut：time："+times;
	}
	
	@PostMapping("/queryByMP")
	public Map<String,Object> queryByMP(@RequestBody  User user){
		Map<String,Object> result= Maps.newHashMap();
		QueryWrapper<User> wrapper=new QueryWrapper<User>();
		if(!StringUtils.isBlank(user.getName())){
			wrapper.eq("name",user.getName());
		}
        wrapper.select("id","name","passWord").or().eq("name","张三").last("limit 0,1");
		List<User> users = userMapper.selectList(wrapper);
		result.put("data",user);
		return result;
	}
	
	
}
