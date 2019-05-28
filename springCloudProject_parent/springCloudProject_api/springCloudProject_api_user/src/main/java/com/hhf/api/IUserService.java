package com.hhf.api;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hhf.entity.User;


public interface IUserService {

	@RequestMapping("/getUserDataByType")
	public List<User> getUserDataByType(@RequestParam("type") Integer type);
}
