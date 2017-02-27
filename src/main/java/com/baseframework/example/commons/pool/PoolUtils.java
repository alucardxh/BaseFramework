package com.baseframework.example.commons.pool;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import redis.clients.jedis.exceptions.JedisException;

/**
 * 
 * pool本身只是对象池。连接池，线程池，只是对pool的扩展。
 * pool产生的背景，在一般情况下创建对象是不需要管理的，但是比如数据库的连接创建代价是很大的所有由pool来管理，这样就大大节约了资源。
 * 初步对pool的理解，pool分为三块， 第一块就是pool本身（ObjectPool）-对象的进出口；
 * 第二块就是生产对象的工厂（PooledObjectFactory）-对象的创建；
 * 第三块就是包装生产出来的对象，对对象进行一些属性状态的封装（PooledObject）-对象的包装。
 * 
 * @author
 *
 */

public class PoolUtils<T> {

	protected GenericObjectPool<T> internalPool;

	public PoolUtils() {
	
	}

//	public PoolUtils(final GenericObjectPoolConfig poolConfig, PooledObjectFactory<T> factory) {
//		initPool(poolConfig, factory);
//	}
	
	
	public PoolUtils(Class<T> clz) {
		initPool(new GenericObjectPoolConfig(), new Factory<T>(clz));
	}

	public PoolUtils(PooledObjectFactory<T> factory) {
		initPool(new GenericObjectPoolConfig(), factory);
	}

	public void initPool(final GenericObjectPoolConfig poolConfig, PooledObjectFactory<T> factory) {

		if (this.internalPool != null) {
			try {
				closeInternalPool();
			} catch (Exception e) {
			}
		}

		this.internalPool = new GenericObjectPool<T>(factory, poolConfig);
	}

	public T borrowObject() throws Exception {
		return internalPool.borrowObject();
	}

	public void returnObject(T obj) {
		internalPool.returnObject(obj);
	}

	public void destroy() {
		closeInternalPool();
	}

	protected void returnBrokenResourceObject(final T resource) {
		try {
			internalPool.invalidateObject(resource);
		} catch (Exception e) {
			throw new JedisException("Could not return the resource to the pool", e);
		}
	}

	protected void closeInternalPool() {
		try {
			internalPool.close();
		} catch (Exception e) {
			throw new JedisException("Could not destroy the pool", e);
		}
	}

	public int getNumActive() {
		if (poolInactive()) {
			return -1;
		}

		return this.internalPool.getNumActive();
	}

	public int getNumIdle() {
		if (poolInactive()) {
			return -1;
		}

		return this.internalPool.getNumIdle();
	}

	public int getNumWaiters() {
		if (poolInactive()) {
			return -1;
		}

		return this.internalPool.getNumWaiters();
	}

	public long getMeanBorrowWaitTimeMillis() {
		if (poolInactive()) {
			return -1;
		}

		return this.internalPool.getMeanBorrowWaitTimeMillis();
	}

	public long getMaxBorrowWaitTimeMillis() {
		if (poolInactive()) {
			return -1;
		}

		return this.internalPool.getMaxBorrowWaitTimeMillis();
	}

	private boolean poolInactive() {
		return this.internalPool == null || this.internalPool.isClosed();
	}

	public void addObjects(int count) {
		try {
			for (int i = 0; i < count; i++) {
				this.internalPool.addObject();
			}
		} catch (Exception e) {
			throw new JedisException("Error trying to add idle objects", e);
		}
	}

	public void clear() {
		this.internalPool.clear();
	}
}
