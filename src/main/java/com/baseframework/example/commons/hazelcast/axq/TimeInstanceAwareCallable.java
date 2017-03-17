package com.baseframework.example.commons.hazelcast.axq;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.Callable;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.HazelcastInstanceAware;
import com.hazelcast.core.IMap;
import com.hazelcast.core.IQueue;

@SuppressWarnings("serial")
public class TimeInstanceAwareCallable implements Callable<String>, HazelcastInstanceAware, Serializable {
	private HazelcastInstance hz;

	@Override
	public void setHazelcastInstance(HazelcastInstance hz) {
		this.hz = hz;
	}

	@Override
	public String call() throws Exception {
		IMap<String, Object> iMap = hz.getMap("myMap");
		IQueue<String> iQueue = hz.getQueue("myQueue");
		System.out.println("iQueue.take() = " + iQueue.take());
		String val = iQueue.take();
		return val + " - " + new Date().toString();
	}

}
