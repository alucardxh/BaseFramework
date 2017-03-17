package com.baseframework.example.commons.tuling;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;

import com.alibaba.fastjson.JSON;
import com.baseframework.utils.HttpClientUtils;



public class TulingApiProcess {
	static String apiKey = "x";
	static String url = "http://www.tuling123.com/openapi/api";

	public static Map<String, Object> getChatAIResponse(String content, String userId)
			throws UnsupportedEncodingException {

		Map<String, String> params = new HashMap<>();

		params.put("key", apiKey);
		params.put("info", content);
		params.put("userid", userId);

		String jsonStr = JSON.toJSONString(params);
		
		String tulingStr = HttpClientUtils.doPostJson(new HttpClient(), url,jsonStr);
		Map<String, Object> map = JSON.parseObject(tulingStr, HashMap.class);
		
		return map;
	}

	public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException {
		// Map<String, String> params = new HashMap<>();
		//
		// params.put("key", apiKey);
		// params.put("info", "最近热门电影");
		// params.put("userid", "1");
		//
		// String json = JsonUtil.object2JsonString(params);
		//
		// HttpRep rep = HttpUtil.doPost(json, url);
		//
		// System.out.println(rep.getContent());
		String[] keys = { "", "" };
		String begin = "CCTV";
		int index = 0;
		while (true) {
			System.out.println("机器人" + (index + 1) + "说：" + begin);
			
			begin = sendAndResponse(keys[index], begin);

			if (index == 0) {
				index = 1;
			} else {
				index = 0;
			}

			Thread.sleep(1000);
		}

	}

	static String sendAndResponse(String apiKey, String content) {
		Map<String, String> params = new HashMap<>();

		params.put("key", apiKey);
		params.put("info", content);
		params.put("userid", "1");

		String jsonStr = JSON.toJSONString(params);
		
		String tulingStr = HttpClientUtils.doPostJson(new HttpClient(), url,jsonStr);
		Map<String, Object> map = JSON.parseObject(tulingStr, HashMap.class);
		return map.get("text").toString();
	}

}