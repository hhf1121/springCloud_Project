package com.hhf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hhf.api.IVipService;
import com.hhf.entity.User;
import com.hhf.fegin.UserFeginService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


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
	@HystrixCommand(fallbackMethod="getUserByTimeHystrixBack")
	//1.用注解的方式:@HystrixCommand  默认开启线程池隔离，服务降级、熔断机制（方法里的逻辑和调用的接口同为一个线程）
	public String getUserDataTimeOut(Integer times) {
		System.out.println("线程名称："+Thread.currentThread().getName()+"getUserDataTimeOut:times="+times);
		return userFegin.getUserDataTimeOut(times);
	}
	
	public String getUserByTimeHystrixBack(Integer times){
		return "请求参数:"+times+"---------服务忙，请稍后再试。。。";
	}
	
	//2.用配置class的方式:  默认开启线程池隔离，服务降级、熔断机制（方法里的逻辑和接口不是一个线程：调用方法时、开启了独立的线程）
	@RequestMapping("/getUserByTimeByClass")
	public String getUserByTimeByClass(Integer times) {
		System.out.println("线程名称："+Thread.currentThread().getName()+"getUserByTimeByClass:times="+times);
		return userFegin.getUserTimeOut(times);
	}
	
	//http-nio-8003-exec-5--->线程池名称：http-nio-8003-exec；当前线程数名称:5
	@RequestMapping("/getUserStrByVip")
	public String getUserStrByVip() {
		System.out.println("getUserStrByVip:线程名称："+Thread.currentThread().getName());
		return userFegin.getUserStr();
	}

}
