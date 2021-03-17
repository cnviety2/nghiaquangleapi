package com.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.NghiaQuangLeStringConverter;
import com.dtos.RequestObject;
import com.dtos.ResponseObject;

@RestController
public class MainController {

	private Map<String, String> map = new HashMap<>();

	@PostConstruct
	private void init() {
		// TODO Auto-generated method stub
		map.put("ã", "ả");
		map.put("Ã", "Ả");
		map.put("ẫ", "ẩ");
		map.put("Ẫ", "Ẩ");
		map.put("ẵ", "ẳ");
		map.put("Ẵ", "Ẳ");
		map.put("ẽ", "ẻ");
		map.put("Ẽ", "Ẻ");
		map.put("ễ", "ể");
		map.put("Ễ", "Ể");
		map.put("ũ", "ủ");
		map.put("Ũ", "Ủ");
		map.put("õ", "ỏ");
		map.put("Õ", "Ỏ");
		map.put("ỗ", "ổ");
		map.put("Ỗ", "Ổ");
		map.put("ỡ", "ở");
		map.put("Ỡ", "Ở");
		map.put("ĩ", "ỉ");
		map.put("Ĩ", "Ỉ");
		map.put("ỹ", "ỷ");
		map.put("Ỹ", "Ỷ");

	}

	@PostMapping(value = "/kwangLee")
	public Object concac(@RequestBody RequestObject reqObject) {
		String content = reqObject.getContent();
		content = NghiaQuangLeStringConverter.convert(content, map);
		return new ResponseEntity<ResponseObject>(new ResponseObject(content, "OK"), HttpStatus.OK);

	}
	
	@GetMapping(value = "/test")
	public Object test() {
		return new ResponseEntity<String>("OK",HttpStatus.OK);
		
	}

}
