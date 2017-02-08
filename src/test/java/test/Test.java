package test;


import java.net.InetAddress;
import java.net.UnknownHostException;



public class Test {
	public static void main(String[] args) throws UnknownHostException {
		
		InetAddress add = InetAddress.getByName("i158470d85.iok.la");
		
		/*   ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://i158470d85.iok.la:61616");  
	        Connection connection = factory.createConnection();  
	        connection.start();  
	          
	        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);  
	        Topic topic = session.createTopic("myTopic.messages");  
	  
	        MessageConsumer consumer = session.createConsumer(topic);  
	        consumer.setMessageListener(new MessageListener() {  
	            public void onMessage(Message message) {  
	                TextMessage tm = (TextMessage) message;  
	                try {  
	                    System.out.println("Received message: " + tm.getText());  
	                } catch (JMSException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	        });  */
	}
}
