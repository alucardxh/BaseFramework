package com.baseframework.example.commons.hazelcast;

import com.baseframework.example.pojo.Student;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ICompletableFuture;
import com.hazelcast.core.IMap;
import com.hazelcast.mapreduce.Context;
import com.hazelcast.mapreduce.Job;
import com.hazelcast.mapreduce.JobTracker;
import com.hazelcast.mapreduce.KeyValueSource;
import com.hazelcast.mapreduce.Mapper;
import com.hazelcast.mapreduce.Reducer;
import com.hazelcast.mapreduce.ReducerFactory;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A simple example that sums the numbers 1 to 10000.
 */
public class BasicMapReduce {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		try {
			HazelcastInstance hz1 = Hazelcast.newHazelcastInstance();
			Hazelcast.newHazelcastInstance();
			Hazelcast.newHazelcastInstance();

			// 创建需要处理的map
			IMap<String, Student> m1 = hz1.getMap("default");
			for (int i = 0; i < 100; i++) {
				Student s = new Student();
				s.setName(i + "Hello_MapReduce");
				s.setAge(String.valueOf(i));
				m1.put(String.valueOf(i), s);
			}

			// 创建一个默认参数的工作节点
			JobTracker tracker = hz1.getJobTracker("myJobTracker");

			// KeyValueSource支持四种容器传入list，map，set，multimap
			KeyValueSource<String, Student> kvs = KeyValueSource.fromMap(m1);

			// 在工作节点上创建一个任务将包装好的数据传入
			Job<String, Student> job = tracker.newJob(kvs);

			// 任务启动将实现的map及reducer传入运行，返回结果
			ICompletableFuture<Map<String, Integer>> myMapReduceFuture = job.mapper(new MyMapper())
					.reducer(new MyReducerFactory()).submit();

			// 获取运算的结果
			Map<String, Integer> result = myMapReduceFuture.get();
			
			System.out.println("学生的年龄总和: " + result.get("allStudentAge"));

			/*// 任务启动将实现的map及reducer传入运行，返回结果
			ICompletableFuture<Map<String, String>> myMapReduceFuture = job.mapper(new MyMapperName())
					.reducer(new MyReducerFactoryName()).submit();
			// 获取运算的结果
			Map<String, String> result = myMapReduceFuture.get();
			
			
			System.out.println("学生姓名写一起: " + result.get("allStudentAge"));
			*/
		} finally {

			Hazelcast.shutdownAll();
		}
	}

	/**
	 * My mapper emits a key value pair per map key. An IMap only ever has one.
	 * <p/>
	 * As I want to do a sum, I am going to accumulate all of these to one key
	 * called "all_values". Unfortunately, this maps all to one node. If we were
	 * doing a classic group by, we would get parallelization.
	 * 
	 * Mapper类泛型定义说明 1，KeyValueSource Key类型 2，KeyValueSource Value类型 3，结果
	 * 输出Key类型 4，结果 输出Value类型
	 */
	private static class MyMapper implements Mapper<String, Student, String, Integer> {
		@Override
		public void map(String key, Student value, Context<String, Integer> context) {
			context.emit("allStudentAge", Integer.valueOf(value.getAge()));
		}
	}

	/**
	 * Returns a Reducer. Multiple reducers run on one Node, therefore we must
	 * provide a factory.
	 */
	/**
	 * ReducerFactory类型泛型定义说明 1，在mapper中泛型的第三个参数定义结果的key的类型 2，Reducer中定义的计算前的类型
	 * 3，Reducer中定义的计算后的类型
	 */
	private static class MyReducerFactory implements ReducerFactory<String, Integer, Integer> {

		@Override
		public Reducer<Integer, Integer> newReducer(String key) {
			return new MyReducer();
		}
	}

	/**
	 * Reducer类型泛型定义说明 1，计算前的类型 2，计算后的类型
	 */
	private static class MyReducer extends Reducer<Integer, Integer> {

		private AtomicInteger sum = new AtomicInteger(0);

		@Override
		public void reduce(Integer value) {
			sum.addAndGet(value);
		}

		@Override
		public Integer finalizeReduce() {
			return sum.get();
		}

	}

	
	
	
	
	
	
	
	
	
	
	
	private static class MyMapperName implements Mapper<String, Student, String, String> {
		@Override
		public void map(String key, Student value, Context<String, String> context) {
			context.emit("allStudentAge", value.getName());
		}
	}

	private static class MyReducerFactoryName implements ReducerFactory<String, String, String> {

		@Override
		public Reducer<String, String> newReducer(String key) {
			return new MyReducerName();
		}
	}

	private static class MyReducerName extends Reducer<String, String> {

		private StringBuilder sb = new StringBuilder();

		@Override
		public void reduce(String value) {
			sb.append(value);
		}

		@Override
		public String finalizeReduce() {
			return sb.toString();
		}

	}
}
