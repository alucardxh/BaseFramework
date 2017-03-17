package com.baseframework.example.commons.lucene.example;

import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.index.Term;
import org.apache.lucene.search.FuzzyQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import com.chenlb.mmseg4j.analysis.ComplexAnalyzer;

public class Client {

	public static void main(String[] args) throws Exception {
		/*final Indexer indexer = new Indexer("C:/Users/Administrator/Desktop/test",new ComplexAnalyzer());
		long a  = System.currentTimeMillis();
		for(int i=0;i<3;i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						try {
							indexer.index("E:/workspace", new TextFileFilter("java"),true);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}finally{
							indexer.close();
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
		}
		long b = System.currentTimeMillis();
		
		System.out.println(b - a);*/
		
		/*Directory dir =  FSDirectory.open(Paths.get("C:/Users/Administrator/Desktop/test"));
		Searcher searcher = new Searcher(dir){
			@Override
			public Query Query() {
				return new FuzzyQuery(new Term("contents", "1231231"));
			}
		};
		searcher.search();
		
		
		Directory dir =  FSDirectory.open(Paths.get("C:/Users/Administrator/Desktop/test"));
		Searcher2 s2 = new Searcher2(dir);
		Query  query  = s2.createQuery("contents", "1231231");
		TopDocs topDocs = s2.executeQuery(query, 10);
		s2.processResult(topDocs);
		*/
		Directory dir =  FSDirectory.open(Paths.get("C:/Users/Administrator/Desktop/test"));
		final Searcher3 s3=new Searcher3Impl(dir);
		s3.run("contents", "1231231", 10);
		/*for(int i=0;i<3;i++){
			new Thread(new  Runnable() {
				public void run() {
					
				}
			}).start();
		}*/
		
		
	}
	
		
}
