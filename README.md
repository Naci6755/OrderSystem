# OrderSystem

Kurze Beschreibung:  
Ein Bestellsystem in Java mit Threads, Lagerverwaltung und JUnit-Tests.

## Features
- Mehrere Bestellungen parallel verarbeitbar
- Lagerbestand prüfen und Exceptions werfen
- Gesamtpreisberechnung
- Statusverwaltung (NEW, PROCESSING, COMPLETED, FAILED)
- JUnit Tests für Produkt- und Order-Logik

## Installation
1. Repository klonen:
   git clone https://github.com/Naci6755/OrderSystem.git
2. Mit Maven bauen:
   mvn clean install

## Nutzung
- `Main.java` starten, um Beispielbestellungen auszuführen
- Tests in `src/test/java` können mit Maven ausgeführt werden:
  mvn test

## Lizenz
(Optional, falls du willst)
