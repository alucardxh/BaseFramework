package com.baseframework.example.commons.lucene.example;

import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.FuzzyQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.PrefixQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;

public abstract class Searcher {
	
	private Directory directory;
	
	
	public Searcher(Directory directory){
		this.directory=directory;
	}
	
	
	/**
	 * 
	 * @param directory 索引目录
	 * @param query	需要查询的关键字
	 * @throws IOException
	 */
	public void search() throws Exception {
		//查询器初始化
		DirectoryReader ireader = DirectoryReader.open(this.directory);
		IndexSearcher isearcher = new IndexSearcher(ireader);
		TopDocs hits = isearcher.search(Query(), 10);
		int a = hits.totalHits;
		System.out.println("包含关键字共"+a+"条");
		for (ScoreDoc scoreDoc : hits.scoreDocs) {
			Document doc = isearcher.doc(scoreDoc.doc);
			System.out.println("包含的文件"+doc.get("dir"));
		}
		
	}
	
	

	
	public abstract Query Query();
	
	
	
	

}
