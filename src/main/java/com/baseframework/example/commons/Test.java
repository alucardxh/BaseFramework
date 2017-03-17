package com.baseframework.example.commons;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Test {

	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");
		mongoDatabase.createCollection("students");

		MongoCollection<Document> collection = mongoDatabase.getCollection("students");
		
	      Document document = new Document("title", "MongoDB").  
	    	         append("description", "database").  
	    	         append("likes", 100).  
	    	         append("by", "Fly");  

	}

}
