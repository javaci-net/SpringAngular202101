package net.javaci;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;

public class SocketServer {

    public static void main(String[] args) throws Exception {
        int port = 8000;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Listening on port:" + 8000);

        while (true) {
            java.net.Socket client = serverSocket.accept();

            System.out.println("Client connected on port:" + client.getPort());

            PrintWriter out = new PrintWriter(client.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));

            String line = br.readLine();
            if (line != null) {
                out.write(line.toUpperCase() + "\r\n");
                out.flush();
            }
        }
        //System.out.println("Closing application");

    }
}
