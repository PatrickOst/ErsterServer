package FirstCICDServerPackage;

import FirstCICDServerPackage.config.Configuration;
import FirstCICDServerPackage.config.ConfigurationManager;
import FirstCICDServerPackage.core.ServerListenerThread;
import com.sun.net.httpserver.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;



public class Hauptklasse {

    private final static Logger LOGGER = LoggerFactory.getLogger(Hauptklasse.class);


    public static void main(String[] args) throws IOException {
        LOGGER.info("---Main-wurde-gestartet---");
        // Erstes Objekt erstellen
        TestKlasse1 TK1 = new TestKlasse1("Patrick", 1985);
        LOGGER.info("Name = " + TK1.getmName());
        LOGGER.info("Name = " + TK1.getmJahrgang());

        //Server implementation
        LOGGER.info("\nServer starting...");
        LOGGER.info("\n------------------------------");
        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");
        Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();
        LOGGER.info("Using Port: " + conf.getPort());
        LOGGER.info("Using WebRoot: " + conf.getWebroot());

        try {
            ServerListenerThread serverListenerThread = new ServerListenerThread(conf.getPort(),conf.getWebroot());
            serverListenerThread.start();
        } catch (IOException e) {
            e.printStackTrace();
            // TODO Handler later
        }
    }
}


