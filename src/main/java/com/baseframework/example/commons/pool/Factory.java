package com.baseframework.example.commons.pool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;


public class Factory<T> extends BasePooledObjectFactory<T> {
	
	
	
	private Class<T> clz;
	
	
	public Factory(Class<T> clz){
		this.clz=clz;
	}
	
	@Override
	public T create() throws Exception {
		return (T) clz.newInstance();
	}

	@Override
	public PooledObject<T> wrap(T obj) {
		// TODO Auto-generated method stub
		return new DefaultPooledObject<T>(obj);
	}

}
