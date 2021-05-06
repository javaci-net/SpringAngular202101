package javaci.jmssample;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumer {

	
	public static void main(String []args) throws JMSException {
		
		//ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616?jms.redeliveryPolicy.initialRedeliveryDelay=10000&jms.redeliveryPolicy.redeliveryDelay=20000&jms.redeliveryPolicy.maximumRedeliveries=3");
		ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616?jms.redeliveryPolicy.initialRedeliveryDelay=1000&jms.redeliveryPolicy.redeliveryDelay=2000&jms.redeliveryPolicy.maximumRedeliveries=3");
		
		Connection connection = factory.createConnection();
		Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
		Queue queue = session.createQueue("MyQueue");

		connection.start(); // -> CONSUMER İÇİN GEREKLİDİR
		MessageConsumer consumer = session.createConsumer(queue);
		System.out.println("Mesaj okunuyor");
		try {
			while (true) {
				
				TextMessage textMsg = (TextMessage) consumer.receive();
				
				//System.out.println(textMsg);
				try {
					System.out.println("Text: " + textMsg.getText());
					session.rollback();
					//session.recover();
					//textMsg.acknowledge();
					//if (number.intValue() == 999)
					//	session.commit();
				} catch (Exception e) {
					System.out.println("Hata olustu:" +  textMsg.getText());
					//session.rollback();
					//session.recover();
				}
						
			}
		} finally {
			session.close();
			connection.close();
		}
		
		
		
	}
}
