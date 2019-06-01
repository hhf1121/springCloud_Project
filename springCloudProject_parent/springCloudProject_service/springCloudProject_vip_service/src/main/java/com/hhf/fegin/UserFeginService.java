package com.hhf.fegin;

import org.springframework.cloud.openfeign.FeignClient;

import com.hhf.api.IUserService;
import com.hhf.fallback.HystrixFallbackUtils;
/**
 * vip-调用user的接口
 * @author hhf
 *
 */
@FeignClient(value="app-hhf-user",fallback=HystrixFallbackUtils.class)
public interface UserFeginService extends IUserService{
	

}
