package FirstCICDServerPackage;

import FirstCICDServerPackage.config.Configuration;
import FirstCICDServerPackage.config.ConfigurationManager;
import com.sun.net.httpserver.*;

import java.lang.System;
import java.net.*;


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

    }
}


