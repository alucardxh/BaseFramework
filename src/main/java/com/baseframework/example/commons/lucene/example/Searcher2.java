package com.baseframework.example.commons.lucene.example;

import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.FuzzyQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;

public class Searcher2 {

	private Directory directory;

	private IndexSearcher isearcher;

	public Searcher2(Directory directory) {
		this.directory = directory;
	}

	public Query createQuery(String fld, String text) {
		return new FuzzyQuery(new Term(fld, text));
	}

	public TopDocs executeQuery(Query query, int pageSize) {
		TopDocs hits = null;
		try {
			DirectoryReader ireader = DirectoryReader.open(this.directory);
			isearcher = new IndexSearcher(ireader);
			hits = isearcher.search(query, pageSize);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return hits;
	}

	public Object processResult(TopDocs topDocs) {
		try {
			int a = topDocs.totalHits;
			System.out.println("包含关键字共" + a + "条");
			for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
				Document doc = this.isearcher.doc(scoreDoc.doc);
				System.out.println("包含的文件" + doc.get("dir"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
