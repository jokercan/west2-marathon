package com.lunacia.scorems.controller;


import com.lunacia.scorems.mapper.LeaderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;

@RestController
public class LeaderController {

	@Autowired
	private LeaderMapper leaderMapper;

	@GetMapping("/getAvg/getAll")
	public LinkedHashMap<String, Object> getSingleAvg(@RequestParam(value = "class_num") int classNum){
		LinkedHashMap<String , Object> hashMap = new LinkedHashMap<>();
		HashMap<String, Object> data = new HashMap<>();
		data.put("class_num" , classNum);
		data.put("avg_score" , leaderMapper.getAllAvg(classNum));
		hashMap.put("data" , data);
		return hashMap;
	}


	//获得及格率
	@GetMapping("/getPassRate")
	public LinkedHashMap<String , Object> getPassRate(@RequestParam(value = "class_num") int classNum){
		HashMap<String ,Object> data = new HashMap<>();
		data.put("class_num" , classNum);
		data.put("pass_rate" , leaderMapper.getPassRate(classNum));
		LinkedHashMap<String , Object> hashMap = new LinkedHashMap<>();
		hashMap.put("data" , data);

		return hashMap;
	}

	@GetMapping("/getGrateRate")
	public LinkedHashMap<String , Object> getGrateRate(@RequestParam(value = "class_num") int classNum){
		HashMap<String ,Object> data = new HashMap<>();
		data.put("class_num" , classNum);
		data.put("grate_rate" , leaderMapper.getGrateRate(classNum));
		LinkedHashMap<String , Object> hashMap = new LinkedHashMap<>();
		hashMap.put("data" , data);

		return hashMap;
	}

	@GetMapping("/getMax")
	public LinkedHashMap<String , Object> getMax(@RequestParam(value = "class_num") int classNum){
		HashMap<String , Object> data = new HashMap<>();
		data.put("class_num" , classNum);
		data.put("max" , leaderMapper.getMax(classNum));
		LinkedHashMap<String , Object> hashMap = new LinkedHashMap<>();
		hashMap.put("data" , data);

		return hashMap;
	}

	@GetMapping("/getMin")
	public LinkedHashMap<String , Object> getMin(@RequestParam(value = "class_num") int classNum){
		HashMap<String , Object> data = new HashMap<>();
		data.put("class_num" , classNum);
		data.put("min" , leaderMapper.getMin(classNum));
		LinkedHashMap<String , Object> hashMap = new LinkedHashMap<>();
		hashMap.put("data" , data);

		return hashMap;
	}
}
