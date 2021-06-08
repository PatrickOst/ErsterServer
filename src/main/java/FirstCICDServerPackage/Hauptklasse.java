package FirstCICDServerPackage;

import java.lang.System;

public class Hauptklasse {

    public static void main(String[] args) {
        System.out.println("---Main-wurde-gestartet---");
        // Erstes Objekt erstellen
        TestKlasse1 TK1 = new TestKlasse1("Patrick", 1985);
        System.out.println("Name = " + TK1.getmName());
        System.out.println("Name = " + TK1.getmJahrgang());

    }
}


