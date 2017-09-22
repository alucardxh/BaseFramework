package com.baseframework.example.netty.simplechat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by louyuting on 16/12/8. 启动服务端
 */
public class SimpleChatClient {
	private final int port;
	private final String host;
	private final Message message;
	private static LinkedBlockingQueue<String> quese  = new LinkedBlockingQueue<String>() ;
	

	public SimpleChatClient(String host, int port,Message message,LinkedBlockingQueue<String> quese) {
		this.host = host;
		this.port = port;
		this.message = message;
		this.quese = quese;
	}

	public void run() throws Exception {
		EventLoopGroup group = new NioEventLoopGroup();

		try {
			// 是一个启动NIO服务的辅助启动类
			Bootstrap bootstrap = new Bootstrap();
			bootstrap.group(group).channel(NioSocketChannel.class).handler(new SimpleChatClientInitializer(message));

			Channel channel = bootstrap.connect(host, port).sync().channel();

			while (true) {
				
				String message = quese.take();
				
				channel.writeAndFlush( message+ "\r\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			group.shutdownGracefully();
		}
	}
	
	
	public String sendAndRecive(String s,Message message) throws InterruptedException{
		quese.put(s);
		return message.getMessage();
	}

	public static void main(String[] args) throws Exception {
		Message message = new Message();
		SimpleChatClient s = new SimpleChatClient("localhost",8007,message, quese);
		String ssss  = s.sendAndRecive("asdasd",message);
		
		s.run();
	
		System.out.println(ssss);
		
	}
	
	
	

}
