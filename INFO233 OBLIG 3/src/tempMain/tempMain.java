package tempMain;

import db.Database;
import db.DatabaseManagingSystem;

//Dette brukes til oppgave D.
public class tempMain {

        public static void main(String[] args) {

            //lager en ny database for Oppgave D.
            Database database = new Database("Oppgave D");
            DatabaseManagingSystem databaseManagingSystem = new DatabaseManagingSystem();

            //kopierer createtable funksjonen fra main klassen.
            DatabaseManagingSystem.createTable(database,
                    "CREATE TABLE IF NOT EXISTS Skole (\n"
                            + "navn text PRIMARY KEY\n"
                            + ");"
            );

            DatabaseManagingSystem.createTable(database,
                    "CREATE TABLE IF NOT EXISTS Kull (\n"
                            + "kullkode text PRIMARY KEY,\n"
                            + "skole text NOT NULL,\n"
                            + "FOREIGN KEY(skole) REFERENCES Skole(navn)\n"
                            + ");"
            );

            DatabaseManagingSystem.createTable(database,
                    "CREATE TABLE IF NOT EXISTS Student (\n"
                            + "nr text PRIMARY KEY,\n"
                            + "navn text NOT NULL,\n"
                            + "kull text NOT NULL,\n"
                            + "FOREIGN KEY (kull) REFERENCES Kull(kode)\n"
                            + ");"
            );

            DatabaseManagingSystem.createTable(database,
                    "CREATE TABLE IF NOT EXISTS Karakter (\n"
                            + "kurskode text NOT NULL REFERENCES Kurs(kode),\n"
                            + "karakter text NOT NULL,\n"
                            + "year integer NOT NULL,\n"
                            + "student text NOT NULL REFERENCES Student(nr)\n"
                            + ");"
            );

            DatabaseManagingSystem.createTable(database,
                    "CREATE TABLE IF NOT EXISTS Kurs (\n"
                            + "kurskode text PRIMARY KEY,\n"
                            + "navn text NOT NULL,\n"
                            + "skole text NOT NULL REFERENCES Skole(navn)\n"
                            + ");"
            );

            //legger til data til databasen ( OPPGAVE D ).
            databaseManagingSystem.insertTable(database,"Skole", "navn","'UiB'");
            databaseManagingSystem.insertTable(database,"Kull", "kullkode, skole", "'2019V', 'UiB'");
            databaseManagingSystem.insertTable(database,"Student","nr, navn, kull", "'1', 'Per', '2019V'");
            databaseManagingSystem.insertTable(database,"Student","nr, navn, kull", "'2', 'Kari', '2019V'");
            databaseManagingSystem.insertTable(database,"Karakter","kurskode, karakter, year, student", "'INFO233', 'A', '2019', '1'");
            databaseManagingSystem.insertTable(database,"Karakter","kurskode, karakter, year, student", "'INFO233', 'A', '2019', '2'");
            databaseManagingSystem.insertTable(database,"Kurs","kurskode, navn, skole","'INFO233', 'Avansert Programmering', 'UiB'" );

        }
}

