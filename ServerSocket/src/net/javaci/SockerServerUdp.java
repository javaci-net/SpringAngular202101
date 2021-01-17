package net.javaci;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SockerServerUdp {

    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(8000);

        byte [] receiveData = new byte[1024];

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        serverSocket.receive(receivePacket);

        String received = new String(receiveData, 0, receiveData.length);
        System.out.println("received:" + received);

        InetAddress IPAddress = receivePacket.getAddress();
        int port = receivePacket.getPort();
        System.out.println("Reply to port: " + port);
        byte[] sendData =  received.toUpperCase().getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
        serverSocket.send(sendPacket);

    }
}
