package com.baseframework.example.commons.ignite;


import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.lang.IgniteRunnable;

public class Test {

	public static void main(String[] args) {
		try (Ignite ignite = Ignition.start()) {
			// Put values in cache.
			final IgniteCache<Integer, String> cache = ignite.getOrCreateCache("myCache");

			cache.put(1, "Hello");
			cache.put(2, "World!");

			// Get values from cache and
			// broadcast 'Hello World' on all the nodes in the cluster.
			ignite.compute().broadcast(new IgniteRunnable() {
				@Override
				public void run() {
					String hello = cache.get(1);
					String world = cache.get(2);

					System.out.println(hello + " " + world);
				}
			});

		}

	}
}
