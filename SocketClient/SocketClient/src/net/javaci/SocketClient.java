package net.javaci;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {

	public static void main(String args[]) throws Exception {
		int port = 8000;
		Socket s = new Socket("localhost", port);
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintWriter out = new PrintWriter(s.getOutputStream());

		out.write("hello there\r\n");
		out.flush();
		String line = br.readLine();
		System.out.println("Read From Server:" + line);
	}

}


