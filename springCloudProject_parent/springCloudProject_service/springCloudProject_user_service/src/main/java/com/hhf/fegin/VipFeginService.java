package com.hhf.fegin;

import org.springframework.cloud.openfeign.FeignClient;

import com.hhf.api.IVipService;


@FeignClient("app-hhf-vip")
public interface VipFeginService extends IVipService{

}
