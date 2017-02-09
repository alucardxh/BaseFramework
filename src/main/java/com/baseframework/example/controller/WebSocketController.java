package com.baseframework.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebSocketController {
	
	@RequestMapping(value = "/webSocket")
	public String test(){
		return "example/webSocket";
	}
	
}
