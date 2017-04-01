package com.baseframework.example.activemq;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 生产者
 * 
 * @author yeahmobi
 *
 */
public class JMSProducer {

	// 默认连接用户名 admin
	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
	// 默认连接密码 admin
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	// 默认连接地址 127.0.0.1 61616
	private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;

	public static void main(String[] args) {
		// 连接工厂
		ConnectionFactory connectionFactory;
		// 连接
		Connection connection = null;
		// 会话 接受或者发送消息的线程
		Session session;
		// 消息的目的地
		Destination destination;
		// 消息生产者
		MessageProducer messageProducer;
		// 实例化连接工厂
		connectionFactory = new ActiveMQConnectionFactory(JMSProducer.USERNAME,
				JMSProducer.PASSWORD, JMSProducer.BROKEURL);
		try {
			// 通过连接工厂获取连接
			connection = connectionFactory.createConnection();
			// 启动连接
			connection.start();
			// 创建session
			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			// 创建一个名称为HelloWorld的消息队列
			// destination = session.createQueue("HelloWorld"); //队列模式

			destination = session.createTopic("HelloWorld");// 订阅/发布模式
			// 创建消息生产者
			messageProducer = session.createProducer(destination);
			// 发送消息
			sendMessage(session, messageProducer);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * 测试循环发送text消息 exit退出
	 * 
	 * @param session
	 * @param messageProducer
	 *            消息生产者
	 * @throws Exception
	 */
	public static void sendMessage(Session session,
			MessageProducer messageProducer) throws Exception {

		Scanner scan = new Scanner(System.in);
		String input;
		while (true) {
			input = scan.next();
			if ("exit".equalsIgnoreCase(input)) {
				break;
			}
			if ("".equals(input.trim())) {
				continue;
			}

			// 创建一条文本消息
			TextMessage message = session.createTextMessage(input);
			// 通过消息生产者发出消息
			messageProducer.send(message);
			System.out.println("ActiveMQ 发送消息：" + input);
			session.commit();
		}
		scan.close();
	}
}