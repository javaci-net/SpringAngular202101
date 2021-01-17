package net.javaci;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SocketClientUdp {

	public static void main(String[] args) throws Exception {
		DatagramSocket clientSocket = new DatagramSocket();
		byte[]sendData = "hello from eclipse".getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("localhost"), 8000);
		clientSocket.send(sendPacket);

		
	}

}

