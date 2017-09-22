package test;

import java.util.List;

import org.apache.http.client.HttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.baseframework.utils.HttpClientUtils2;

public class Test {
	public static void main(String[] args) {
		
		
		
		
		HttpClient httpGet = HttpClientUtils2.getHttpClient();
		String infoPage = HttpClientUtils2.doGet(httpGet, "http://www.meiguoshenpo.com/meiri/d195215.html");
		Document infoPageDoc = Jsoup.parse(infoPage);
		StringBuilder stringBuilder = new StringBuilder();
		List<Element> Info = infoPageDoc.select(".show_cnt p").subList(1, 8);
		for (Element element : Info) {
			stringBuilder.append(element);
		}
		String s = stringBuilder.toString();
		System.out.println(s);
		String ss = s.replaceAll("<\\/?(?!br|p|/p)[^>]*>", "");
		System.out.println(ss);


	}
}
