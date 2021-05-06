package javaci.jmssample;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Producer {

	public static void main(String[] args) throws JMSException {
		ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		Connection connection = factory.createConnection();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Queue queue = session.createQueue("MyQueue");

		MessageProducer producer = session.createProducer(queue);
		producer.setTimeToLive(30000);
		Scanner s = new Scanner(System.in);
		System.out.println("Lutfen gondereceginiz mesaji girip entera basin");
		while(true) {
			String line = s.nextLine();
			
			if ("END".equals(line))
				break;
			TextMessage msg = session.createTextMessage(line);
			//msg.setJMSPriority(Integer.parseInt(line));
			producer.send(msg);
		}

	}

}
