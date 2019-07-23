package com.hhf.fallback;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hhf.entity.User;
import com.hhf.fegin.UserFeginService;

@Component
public class HystrixFallbackUtils implements UserFeginService{

	@Override
	public List<User> getUserDataByType(Integer type) {
		List<User> result=new ArrayList<User>();
		User user=new User();
		user.setName("hystrix:服务降级");
		result.add(user);
		return result;
	}

	@Override
	public String getUserDataTimeOut(Integer times) {
		return null;
	}

	@Override
	public String getUserStr() {
		
		return "HystrixFallback方式：[调用超时，请稍后再试...]";
	}

	@Override
	public String getUserTimeOut(Integer times) {
		// TODO Auto-generated method stub
		return "HystrixFallback方式：参数为："+times+"[调用超时，请稍后再试...][getUserTimeOut]";
	}
	
}

