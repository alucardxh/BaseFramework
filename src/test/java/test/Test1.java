package test;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.BeanUtils;


public class Test1 {
	
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException  {
	/*	 ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://i158470d85.iok.la:61616");  
	        Connection connection = factory.createConnection();  
	        connection.start();  
	          
	        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);  
	        Topic topic = session.createTopic("myTopic.messages");  
	  
	        MessageProducer producer = session.createProducer(topic);  
	        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);  
	  
	        while(true) {  
	            TextMessage message = session.createTextMessage();  
	            message.setText("message_" + System.currentTimeMillis());  
	            producer.send(message);  
	            System.out.println("Sent message: " + message.getText());  
	  
	            try {  
	                Thread.sleep(1000);  
	            } catch (InterruptedException e) {  
	                e.printStackTrace();  
	            }  
	        }  */
		
		
		
		
		Student s = new Student();
		s.setAge("11111");
		Student s1 = new Student();
		s1.setAge("sdfsadf");
		
		BeanUtils.copyProperties(s1, s);
		
		
		
		
		
		System.out.println(s);
		
	}

}
