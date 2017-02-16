package com.baseframework.example.service.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PropService {
	
	@Value("${jdbc.driverClassName}")
	private String s;
	
	public String s(){
		return s;
	}

}
