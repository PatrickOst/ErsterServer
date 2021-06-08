package FirstCICDServerPackage.core;

import FirstCICDServerPackage.Hauptklasse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListenerThread extends Thread{
    private int port;
    private String webroot;
    private ServerSocket serverSocket;

    private final static Logger LOGGER = LoggerFactory.getLogger(ServerListenerThread.class);

    public ServerListenerThread(int port, String webroot) throws IOException {
        this.port = port;
        this.webroot = webroot;
        this.serverSocket = new ServerSocket(this.port);
    }

    @Override
    public void run(){
        try {
            while(serverSocket.isBound() && !serverSocket.isClosed()){
                Socket socket = serverSocket.accept();

                LOGGER.info("Connection accepted: " + socket.getInetAddress());

                HttpConnectionWorkerThread workerThread = new HttpConnectionWorkerThread(socket);
                workerThread.start();
        }



        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("Problem with setting socket",e);
        } finally {
            if(serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
