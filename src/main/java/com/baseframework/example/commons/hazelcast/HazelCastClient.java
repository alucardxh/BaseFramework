package com.baseframework.example.commons.hazelcast;

import java.util.Map;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IQueue;

public class HazelCastClient {
	
	
	
	public static void main(String[] args) {
		ClientConfig config = new ClientConfig();
		HazelcastInstance h  = HazelcastClient.newHazelcastClient(config);
		
//		Map<Integer,String> map = h.getMap("customers");
//		System.out.println(map.get(1));
//		System.out.println(map.get(2));
//		System.out.println(map.get(3));
		IQueue<String> iQueue= h.getQueue("axq");
		
		try {
			System.out.println(iQueue.take()+"");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
