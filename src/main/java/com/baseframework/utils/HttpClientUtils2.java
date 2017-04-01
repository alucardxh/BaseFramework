package com.baseframework.utils;

import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientUtils2 {

	/** 连接超时时间 */
	private static final int defaultConnectionTimeout = 10000;
	/** 回应超时时间 */
	private static final int defaultSoTimeout = 30000;
	/** 闲置连接超时时间 */
	private static final int defaultIdleConnTimeout = 60000;
	private static final int defaultMaxConnPerHost = 30;
	private static final int defaultMaxTotalConn = 80;

	/** 默认等待HttpConnectionManager返回连接超时（只有在达到最大连接数时起作用）*/
	private static final long defaultHttpConnectionManagerTimeout = 3 * 1000;

	private static PoolingHttpClientConnectionManager connectionManager;
	
	
	private static RequestConfig requestConfig;

	static {
		connectionManager = new PoolingHttpClientConnectionManager();
		connectionManager.setDefaultMaxPerRoute(defaultMaxConnPerHost);
		connectionManager.setMaxTotal(defaultMaxTotalConn);

		/*IdleConnectionTimeoutThread ict = new IdleConnectionTimeoutThread();
		ict.addConnectionManager(connectionManager);
		ict.setConnectionTimeout(defaultIdleConnTimeout);

		ict.start();*/
		
		
		IdleConnectionMonitorThread icmt = new IdleConnectionMonitorThread(connectionManager);
		
		
		connectionManager.closeExpiredConnections();
		//关闭空闲超过30秒的连接
		connectionManager.closeIdleConnections(30, TimeUnit.SECONDS);
	}

	public static HttpClient getHttpClient() {
		requestConfig = RequestConfig.custom().setConnectTimeout(defaultConnectionTimeout).setSocketTimeout(defaultSoTimeout).build();
		CloseableHttpClient httpClient = HttpClients.createMinimal(connectionManager);
		return httpClient;
	}

	public static String doPost(HttpClient httpClient, String url, List<BasicNameValuePair> params) {
		String body = "";

		try {
			HttpPost httpPost = new HttpPost(url);
			httpPost.setConfig(requestConfig);
			if (params != null) {
				HttpEntity entity = new UrlEncodedFormEntity(params, "UTF-8");
				httpPost.setEntity(entity);
			}
			HttpResponse response = httpClient.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				body = EntityUtils.toString(response.getEntity(),"UTF-8");
			}
			httpPost.releaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return body;
	}

	public static String doPostJson(HttpClient httpClient, String url, String json) {
		String body = "";
		try {
			HttpPost httpPost = new HttpPost(url);
			httpPost.setConfig(requestConfig);
			httpPost.addHeader("Content-type","application/json; charset=UTF-8");  
			httpPost.setHeader("Accept", "application/json");
			StringEntity stringEntity = new StringEntity(json, Charset.forName("UTF-8"));
			httpPost.setEntity(stringEntity);
			HttpResponse response = httpClient.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				body = EntityUtils.toString(response.getEntity(),"UTF-8");
			}
			httpPost.releaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return body;
	}

	public static String doPostXml(HttpClient httpClient, String url, String xml) {
		String body = "";
		try {
			HttpPost httpPost = new HttpPost(url);
			httpPost.setConfig(requestConfig);
			httpPost.addHeader("Content-Type", "text/xml; charset=UTF-8"); 
			httpPost.setEntity(new StringEntity(xml, "UTF-8"));
			HttpResponse response = httpClient.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				body = EntityUtils.toString(response.getEntity(),"UTF-8");
			}
			httpPost.releaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return body;
	}

	public static String doGet(HttpClient httpClient, String url) {
		String body = "";
		try {
			HttpGet httpGet = new HttpGet(url);
			httpGet.setConfig(requestConfig);
			HttpResponse response = httpClient.execute(httpGet);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				body = EntityUtils.toString(response.getEntity(),"UTF-8");
			}
			httpGet.releaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return body;
	}

	public static byte[] getFile(HttpClient httpClient, String url) {
		byte[] file = null;
		try {
			HttpGet httpGet = new HttpGet(url);
			httpGet.setConfig(requestConfig);
			HttpResponse response = httpClient.execute(httpGet);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				file = EntityUtils.toByteArray(response.getEntity());
			}
			httpGet.releaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file;
	}

	public static String uploadFile(HttpClient httpClient, String url, List<BasicNameValuePair> params, String filename,
			byte[] data) {
		String body = "";
		try {
			//File file = new File(filename);
			//FileUtils.writeByteArrayToFile(file, data);
			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			for (BasicNameValuePair pair : params) {
				builder.addPart(pair.getName(), new StringBody(pair.getValue(), ContentType.MULTIPART_FORM_DATA));
			}
			builder.addPart(filename,new ByteArrayBody(data, filename));
			HttpEntity entity = builder.build();
			HttpPost httpPost = new HttpPost(url);
			httpPost.setConfig(requestConfig);
			httpPost.setEntity(entity);
			httpClient.execute(httpPost);
			HttpResponse response = httpClient.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				body = EntityUtils.toString(response.getEntity(),"UTF-8");
			}
			httpPost.releaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return body;
	}

	
	
	
	
	
	private static class IdleConnectionMonitorThread extends Thread {
		
		private final HttpClientConnectionManager connMgr;
		private volatile boolean shutdown;
		
		public IdleConnectionMonitorThread(HttpClientConnectionManager connMgr) {
			super();
			this.connMgr = connMgr;
		}
		
		@Override
		public void run() {
			try {
				while (!shutdown) {
					synchronized (this) {
						wait(5000);
						System.out.println("清空失效连接...");
						// 关闭失效连接
						connMgr.closeExpiredConnections();
						//关闭空闲超过30秒的连接
						connMgr.closeIdleConnections(defaultIdleConnTimeout, TimeUnit.SECONDS);
					}
				}
			} catch (InterruptedException ex) {
			}
		}
		
		public void shutdown() {
			shutdown = true;
			synchronized (this) {
				notifyAll();
			}
		}
	}
	
	
}




