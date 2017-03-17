package com.baseframework.example.commons.lucene.example;

import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;

public class Indexer {

	private IndexWriter iwriter;
	
	private Directory directory;
	
	
	public Indexer() throws IOException {
		this("",new StandardAnalyzer());
	}
	
	public Indexer(Analyzer analyzer) throws IOException {
		this("",analyzer);
	}
	public Indexer(String IndexDir) throws IOException {
		this(IndexDir,new StandardAnalyzer());
	}
	/**
	 * 初始化索引对象,确定索引目录的存储方式及路径，
	 * 将此法解析器添加至索引对象配置文件，将其为参数配置到索引对象中。
	 * @param indexDir
	 * @throws IOException
	 */
	public Indexer(String indexDir,Analyzer analyzer) throws IOException {
		// 创建分词器对象
		if (StringUtils.isBlank(indexDir)) {
			// 创建内存目录对象
			directory = new RAMDirectory();
		} else {
			// 创建硬盘目录对象
			directory = FSDirectory.open(Paths.get(indexDir));
		}
		IndexWriterConfig config = new IndexWriterConfig(analyzer);
		iwriter = new IndexWriter(directory, config);
	}

	/**
	 * 遍历文件夹下的文件，并添加至IndexWriter对象中
	 * @param dataDir	需要查询文件的文件路径
	 * @param filter	文件后缀名过滤器
	 * @param isRecursion	是否递归该文件夹下的所有文件
	 * @return
	 * @throws Exception
	 */
	public int index(String dataDir, FileFilter filter,boolean isRecursion) throws Exception {
		File[] files = new File(dataDir).listFiles();
		for (File file : files) {
			if (!file.isDirectory() && !file.isHidden() && file.exists() && file.canRead()
					&& (filter == null || filter.accept(file))) {
				indexFile(file);
			}else if(file.isDirectory()&&isRecursion){
				index(file.getPath(),filter,isRecursion);
			}
		}
		return iwriter.numDocs();
	}
	
	
	/**
	 * 将转化的后的Document对象添加至IndexWriter对象中
	 * @param file
	 * @throws Exception
	 */
	private void indexFile(File file) throws Exception {
		System.out.println("被创建索引的文件" + file.getCanonicalPath());
		Document doc = getDocument(file);
		iwriter.addDocument(doc);
	}

	/**
	 * 将file转换为Document对象
	 * 
	 * @param file 需要查询的文件对象
	 * @return
	 * @throws Exception
	 */
	protected Document getDocument(File file) throws Exception {
		Document doc = new Document();
		doc.add(new TextField("contents", new FileReader(file)));
		doc.add(new TextField("filename", file.getName(), Field.Store.YES));
		doc.add(new TextField("dir", file.getCanonicalPath(), Field.Store.YES));
		return doc;
	}

	/**
	 * 关闭索引对象
	 * 
	 * @throws IOException
	 */
	public void close() throws IOException {
		iwriter.close();
	}
	
	
	/**
	 * 提交添加的文档
	 * 
	 * @throws IOException
	 */
	public void commit() throws IOException {
		iwriter.commit();
	}

	public Directory getDirectory() {
		return directory;
	}
	
	
	/*private static void listFiles(String path,FileFilter filter) throws Exception{
		File file = new File(path);
		for (File f : file.listFiles()) {
			if(f.isDirectory()){
				System.out.println(f.getCanonicalPath());
				listFiles(f.getPath(),filter);
			}else if(!f.isDirectory() && !f.isHidden() && f.exists() && f.canRead()
					&& (filter == null || filter.accept(f))){
				System.out.println(f.getCanonicalPath());
				
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		listFiles("C:/Users/Administrator",new TextFileFilter("txt"));
	}*/
}
