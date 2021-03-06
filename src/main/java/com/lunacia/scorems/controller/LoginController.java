package com.lunacia.scorems.controller;


import com.lunacia.scorems.mapper.LoginMapper;
import com.lunacia.scorems.utils.Encode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

	@Autowired
	private LoginMapper loginMapper;

	@PostMapping("/login")
	//@RequestParam("id") String username, @RequestParam("passwd") String passwd
	public HashMap<String, Object> login(@RequestBody Map<String, Object> resMap) {
		HashMap<String, Object> map = new HashMap<>();
		String username = resMap.get("id").toString();
		String passwd = resMap.get("passwd").toString();
		if (username.equals(passwd)) {
			login(username, passwd, map);
		} else {
			Encode encode = new Encode();
			String secretBytes = encode.MD5(passwd);
			login(username, secretBytes, map);
		}
		return map;
	}

	private void login(String username, String passwd, HashMap<String, Object> map) {
		if (loginMapper.login(username).equals(passwd)) {
			map.put("code", 200);
			map.put("massage", "登录成功");
			map.put("isFirst", 1);
			map.put("isLeader", loginMapper.findById(username).getLeader());
		} else {
			map.put("code", 403);
			map.put("message", "登录失败");
		}
	}


}
