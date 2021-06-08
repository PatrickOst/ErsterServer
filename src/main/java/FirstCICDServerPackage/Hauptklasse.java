package FirstCICDServerPackage;

import FirstCICDServerPackage.config.Configuration;
import FirstCICDServerPackage.config.ConfigurationManager;
import com.sun.net.httpserver.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.System;
import java.net.*;
import java.nio.charset.StandardCharsets;


public class Hauptklasse {

    public static void main(String[] args) {
        System.out.println("---Main-wurde-gestartet---");
        // Erstes Objekt erstellen
        TestKlasse1 TK1 = new TestKlasse1("Patrick", 1985);
        System.out.println("Name = " + TK1.getmName());
        System.out.println("Name = " + TK1.getmJahrgang());

        //Server implementation
        System.out.println("\nServer starting...");
        System.out.println("\n------------------------------");
        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");
        Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();
        System.out.println("Using Port: " + conf.getPort());
        System.out.println("Using WebRoot: " + conf.getWebroot());

        try {
            ServerSocket serverSocket = new ServerSocket(conf.getPort());
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            String html = "<html><head><title>Simple Java HTTP Server</title></head><body><h1>This page was served using my Simple Java HTTP Server</h1></body></html>";

            final String CRLF = "\n\r";
            String response =
                    "HTTP/1.1 200 OK" + CRLF + // Status Line : HTTP Version Response_Code Response_Message
                            "Content-Length: " + html.getBytes().length + CRLF + // Header
                            CRLF +
                            html +
                            CRLF + CRLF;

            outputStream.write(response.getBytes());


            inputStream.close();
            outputStream.close();
            socket.close();
            serverSocket.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


