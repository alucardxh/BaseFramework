package com.baseframework.example.commons.hazelcast;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentMap;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.MultiMap;

public class HazelCastCollections {

	public static void main(String[] args) {
		Config config = new Config();
		HazelcastInstance instance = Hazelcast.newHazelcastInstance(config);
		

		/**
		 * 队列
		 */
		Queue<String> queue = instance.getQueue("queue");
		queue.offer("Tom");
		queue.offer("Mary");
		queue.offer("Jane");
		queue.poll();
		queue.peek();
		queue.size();

		/**
		 * map
		 */
		Map<Integer, String> map = instance.getMap("map");
		map.put(1, "Joe");
		map.put(2, "Ali");
		map.put(3, "Avi");

		/**
		 * 并发map
		 */
		ConcurrentMap<String, String> currentMap = instance.getMap("concurrentMap");
		currentMap.put("key", "value");
		currentMap.get("key");
		currentMap.putIfAbsent("somekey", "somevalue");
		currentMap.putIfAbsent("somekey", "somevalue111");
		currentMap.replace("key", "value", "newvalue");
		currentMap.get("key");

		/**
		 * 可重复keyMap
		 */
		MultiMap<String, String> multiMap = instance.getMultiMap("multimap");
		multiMap.put("key", "value1");
		multiMap.put("key", "value2");
		multiMap.put("key", "value3");
		Collection<String>  values= multiMap.get("key");
		for (String string : values) {
			System.out.println(string);
		}
		
		
		/**
		 * List
		 */
		List<String> list = instance.getList("list");
		list.add("a");
		list.add("b");
		list.add("c");
		
		
	}

}
