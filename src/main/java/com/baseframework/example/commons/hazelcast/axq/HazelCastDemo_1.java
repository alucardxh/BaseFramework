package com.baseframework.example.commons.hazelcast.axq;

import java.util.Map;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IQueue;

public class HazelCastDemo_1 {

	public static void main(String[] args) {

		Config cfg = new Config();
		HazelcastInstance instance = Hazelcast.newHazelcastInstance(cfg);

		Map<Integer, String> mapCustomers = instance.getMap("customers");
		mapCustomers.put(5, "axq_5_map");
		mapCustomers.put(6, "axq_6_map");
		mapCustomers.put(7, "axq_7_map");

		// System.out.println("Customer with key 1: " + mapCustomers.get(1));
		// System.out.println("Map Size:" + mapCustomers.size());

		IQueue<String> iQueue = instance.getQueue("axq");
		try {
			iQueue.put("axq_5_queue");
			iQueue.put("axq_6_queue");
			iQueue.put("axq_7_queue");
			iQueue.put("axq_8_queue");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
