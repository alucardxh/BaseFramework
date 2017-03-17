package com.baseframework.example.commons.hazelcast.axq;

import java.util.Map;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IQueue;

public class HazelCastDemo {

	public static void main(String[] args) {

		Config cfg = new Config();
		HazelcastInstance instance = Hazelcast.newHazelcastInstance(cfg);

		// HazelcastInstance instances = HazelcastClient.newHazelcastClient();

		Map<Integer, String> mapCustomers = instance.getMap("customers");

		mapCustomers.put(1, "axq_1_map");
		mapCustomers.put(2, "axq_2_map");
		mapCustomers.put(3, "axq_3_map");

		// 阻塞队列
		IQueue<String> iQueue = instance.getQueue("axq");
		try {
			iQueue.put("axq_1_queue");
			iQueue.put("axq_2_queue");
			iQueue.put("axq_3_queue");
			iQueue.put("axq_4_queue");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
