package net.javaci;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class HttpThread extends Thread {

    private Socket client;


    public HttpThread(Socket client) {
        this.client = client;


    }
    @Override
    public void run() {
        System.out.println("Client thread started." + Thread.currentThread().getName());

        try {
            processRequest();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processRequest() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream());
        String line = br.readLine();
        System.out.println("Line:" + line);
        if (line == null) {
            // TODO Bad request
            return;
        }
        String parts[] = line.split(" ");
        if (!"GET".equals(parts[0])) {
            // TODO unsupported request
            return;
        }
        if (parts[1].equals("/studentList")) {
            processStudentList(out);
        } else {
            HttpResponse resp = new HttpResponse(out, "." + parts[1]);
            resp.sendResponse();
        }
        client.close();


    }

    private void processStudentList(PrintWriter out) throws JsonProcessingException {
        Student s1 = new Student();
        s1.setName("Koray Gecici");
        s1.setAge(41);
        s1.setId(3333);

        Student s2 = new Student();
        s2.setName("Volkan İstek");
        s2.setAge(40);
        s2.setId(4444);

        List<Student> students = new ArrayList();
        students.add(s1);
        students.add(s2);

        //Creating the ObjectMapper object
        ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        String jsonString = mapper.writeValueAsString(students);

        out.println("HTTP/1.1 " + 200 + " OK");
        out.println("Content-Type: application/json" );
        out.println();
        out.println(jsonString);
        out.close();
    }
}
