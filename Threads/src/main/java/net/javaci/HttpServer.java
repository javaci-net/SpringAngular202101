package net.javaci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;

public class HttpServer {

    public void startServer() throws IOException {
        int port = 8000;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Listening on port:" + 8000);

        while (true) {
            java.net.Socket client = serverSocket.accept();
            new HttpThread(client).start();
        }
    }

    public static void main(String[] args) throws Exception {
        new HttpServer().startServer();

    }
}
