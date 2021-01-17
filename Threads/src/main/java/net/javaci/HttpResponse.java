package net.javaci;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HttpResponse {

    private PrintWriter out;

    private String file;

    public HttpResponse(PrintWriter out, String file) {
        this.out = out;
        this.file = file;
    }

    public void sendResponse() {
        try {
            int httpStatus = 200;
            String fileContent;
            try {
                //fileContent = new String(Files.readAllBytes(Paths.get(file)), StandardCharsets.UTF_8);
                char []content = new char[(int)new File(file).length()];
                new FileReader(file).read(content, 0, content.length);
                fileContent = new String(content);
            } catch (Exception e) {
                httpStatus = 404;
                out.println("HTTP/1.1 " + httpStatus);
                return;
            }
            out.println("HTTP/1.1 " + httpStatus + " OK");
            //out.println("Content-Type: application/json" );
            out.println();
            out.println();
            out.println(fileContent);

        } finally {
            out.flush();
            out.close();
        }
    }


}
