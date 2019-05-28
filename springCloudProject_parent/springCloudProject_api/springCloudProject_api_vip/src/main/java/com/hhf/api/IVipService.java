package com.hhf.api;

import org.springframework.web.bind.annotation.RequestMapping;


public interface IVipService {

	@RequestMapping("/getVipStr")
	public String getVipStr();
	
}
