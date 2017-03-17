package com.baseframework.example.commons.hazelcast.axq;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.core.IQueue;

/**
 * 异步计算
 * 
 * @author anxiaoqiang
 *
 */
public class ExecutionExample {
	public static void main(String[] args) throws Exception {
		Config conf = new Config();
		HazelcastInstance hz = Hazelcast.newHazelcastInstance(conf);
		ExecutorService exec = hz.getExecutorService("exec");
		IMap<String, Object> iMap = hz.getMap("myMap");
		iMap.put("axq", "axq");

		IQueue<String> iQueue = hz.getQueue("myQueue");
		iQueue.put("axq");
		List<Future<String>> resultList = new ArrayList<Future<String>>();

		// 十个任务
		for (int i = 0; i < 10; i++) {
			Future<String> timeFuture = exec.submit(new TimeInstanceAwareCallable());
			// String theTime = timeFuture.get();
			resultList.add(timeFuture);
		}

		// 任务再处理
		for (Future<String> fs : resultList) {
			System.out.println(fs.get()); // 打印各个线程（任务）执行的结果
		}

	}
}
