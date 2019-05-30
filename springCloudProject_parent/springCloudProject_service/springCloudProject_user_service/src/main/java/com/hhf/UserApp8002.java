package com.hhf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableEurekaClient  //注册中心是eureka
@EnableDiscoveryClient//注册中心可以不是eureka
@EnableFeignClients
public class UserApp8002 {

	public static void main(String[] args) {
		SpringApplication.run(UserApp8002.class, args);
	}
	
}
