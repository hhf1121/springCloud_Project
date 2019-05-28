package com.hhf.fegin;

import org.springframework.cloud.openfeign.FeignClient;

import com.hhf.api.IUserService;
/**
 * vip-调用user的接口
 * @author hhf
 *
 */

@FeignClient("app-hhf-user")
public interface UserFeginService extends IUserService{
	

}
