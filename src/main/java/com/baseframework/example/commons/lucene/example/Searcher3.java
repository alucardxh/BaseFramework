package com.baseframework.example.commons.lucene.example;


import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;

public abstract class  Searcher3 {
	
	protected Directory directory;

	protected IndexSearcher isearcher;

	public Searcher3(Directory directory) {
		this.directory = directory;
	}

	public  abstract Query createQuery(String fld, String text);
		

	public abstract TopDocs executeQuery(Query query, int pageSize);

	
	public abstract Object processResult(TopDocs topDocs);
	
	
	public void run(String fld, String text,int pageSize ){
		Query query = this.createQuery(fld, text);
		
		TopDocs  td = this.executeQuery(query, pageSize);
		
		this.processResult(td);
	}

}
