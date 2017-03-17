package com.baseframework.example.commons.hazelcast.axq;

import java.util.Map;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IQueue;

public class HazelCastDemo_3 {

	public static void main(String[] args) {

		Config cfg = new Config();
		HazelcastInstance instance = Hazelcast.newHazelcastInstance(cfg);

		// map
		Map<Integer, String> mapCustomers = instance.getMap("customers");
		mapCustomers.put(8, "axq_8_map");
		mapCustomers.put(9, "axq_9_map");
		mapCustomers.put(10, "axq_10_map");

		// System.out.println("Customer with key 1: " + mapCustomers.get(1));
		// System.out.println("Map Size:" + mapCustomers.size());

		// queue
		IQueue<String> iQueue = instance.getQueue("customers");
		try {
			iQueue.put("axq_8_queue");
			iQueue.put("axq_9_queue");
			iQueue.put("axq_10_queue");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println("First customer: " + queueCustomers.poll());
		// System.out.println("Second customer: " + queueCustomers.peek());
		// System.out.println("Queue size: " + queueCustomers.size());
	}
}
