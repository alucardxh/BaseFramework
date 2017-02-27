package com.baseframework.example.commons.pool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;


public class ConnectionFactory extends BasePooledObjectFactory<DBHelper> {

	@Override
	public DBHelper create() throws Exception {
		return new DBHelper();
	}

	@Override
	public PooledObject<DBHelper> wrap(DBHelper obj) {
		return new DefaultPooledObject<DBHelper>(obj);
	}

}
