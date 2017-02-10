package com.baseframework.example.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.baseframework.utils.HttpClientUtils;

public class ScriptCode {

	private static final String URL = "http://ccc.spdb.com.cn/news/qgxhd/index***.shtml";

	public static void main(String[] args) {
		HttpClient httpClient = HttpClientUtils.getHttpClient();

		String url = "";
		for (int i = 0; i < 24; i++) {
			if (i < 1) {
				url = URL.replace("***", "");
			} else {
				url = URL.replace("***", "_" + i);
			}

			String httpResp = HttpClientUtils.doGet(httpClient, url);
			Document doc = Jsoup.parse(httpResp);
			Elements elements = doc.select(".main_body_left_noticehead .newsright_news");
			int j = 0;
			int p = i + 1;
			for (Element element : elements) {
				j += 1;
				System.out.println("正在爬第" + p + "页," + j + "条信息");
				Element e1 = element.child(1).child(0);
				String discountPath = e1.attr("href");
				System.out.println(discountPath);
				
				String ss="";
				if(discountPath.endsWith("html")){
					ss=discountPath;
				}else{
					ss="http://ccc.spdb.com.cn/" + discountPath;
				}
				String detailResp = HttpClientUtils.doGet(httpClient,ss);
				Document doc1 = Jsoup.parse(detailResp);
				String discountName = e1.text();
				String fileName = discountName.replaceAll("(\\\\)|(\\/)|(\\:)|(\\*)|(\\?)|(\\\")|(\\<)|(\\>)|(\\|)",
						"");

				File folder = new File("discount/" + fileName);
				if (!folder.exists()) {
					folder.mkdirs();
				} else {
					System.out.println("重复:" + fileName);
				}
				Elements elementss = doc1.select("tbody img");
				for (Element element2 : elementss) {
					String discountImg = element2.attr("src");
					String imgName = discountImg.substring(discountImg.lastIndexOf("/") + 1,
							discountImg.lastIndexOf("."));
					String suffix = discountImg.split("\\.")[discountImg.split("\\.").length - 1];
					String s = "";
					if (discountPath.endsWith("/")) {
						s = discountPath;
					} else {
						if (discountPath.endsWith("html")) {
							
							int last = discountPath.lastIndexOf("/");
							
							s = discountPath.substring(0, last)+"/";
							
						} else {
							s = discountPath + "/";
						}
					}
					System.out.println("discount/" + fileName + "/" + imgName + "." + suffix);
					System.out.println("http://ccc.spdb.com.cn" + s + discountImg);
					try {
						FileUtils.writeByteArrayToFile(new File("discount/" + fileName + "/" + imgName + "." + suffix),
								HttpClientUtils.getFile(httpClient, "http://ccc.spdb.com.cn" + s + discountImg));
					} catch (Exception e) {
						e.printStackTrace();
						continue;
					}

				}
			}

		}

	}

}
