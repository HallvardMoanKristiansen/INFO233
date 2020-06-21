package Main;

import db.Database;
import db.DatabaseManagingSystem;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/*
 * SRC:
 * Disclamer: Har samarbeidet mye med David Kvasnes og Eivind Nordling så noe kode kan være lik.
 * https://github.com/EwyBoy/SQL-Test/tree/master/src
 * http://www.sqlitetutorial.net/sqlite-java/sqlite-jdbc-driver/
 * http://www.sqlitetutorial.net/sqlite-java/create-table/
 * http://www.sqlitetutorial.net/sqlite-create-table/
 * http://www.sqlitetutorial.net/sqlite-java/insert
 * http://www.sqlitetutorial.net/sqlite-java/sqlite-jdbc-driver/?fbclid=IwAR1-eUZN7TqhcwwhIqbF9SWvkUhXHmgcuG5UwRaD92a7q5MB0yTNZA6V-pc
 */

public class Main extends Application {

    //lager ny database, med navn "database"
    public static Database database = new Database("database");

    @Override
    public void start(Stage primaryStage) throws Exception{
        //henter fra Main.fxml filen når den skal displaye pop up en

        if(resource != null) {
            Parent root = FXMLLoader.load(getClass().getResource("../fx/fxml/" + resource));
            primaryStage.setTitle("SQL");
            primaryStage.setScene(new Scene(root, 720, 540));
            primaryStage.show();
        }
    }

    //lager private funksjon som skal skape databasen.
    private static void createDatabase() {
        //lager ny database med navn "database".

        //prøver å establishe en connection
        try (Connection connection = DriverManager.getConnection(database.getUrl())) {
            System.out.println("Connection has been established");
        }
        //catcher exception
        catch(SQLException e) {
            e.printStackTrace();
        }

        //http://www.sqlitetutorial.net/sqlite-java/create-table/
        //lager et databasemanagingsystem, hvor man setter inn verdien til de ulike klassene.
        //Brukte "oprettdatabase.sql" gitt i uib, og skrev om slik at det ble lesbart for java.
        //under legger jeg til alle tables, og legger inn de valusene de skal ha.
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

        matTabellen(database);


    }
    //mater tabellen med data og ser om de havner i databasen. Har databasen i samme rekkefølge som den jeg satte inn over. Skole - kull - student - karakter - kurs.
    private static void matTabellen(Database database) {
        DatabaseManagingSystem dms = new DatabaseManagingSystem();

        dms.insertTable(database, "Skole", "navn", "'UiB'");
        dms.insertTable(database, "Skole", "navn", "'LCK'");
        dms.insertTable(database, "Skole", "navn", "'MIT'");
        dms.insertTable(database, "Skole", "navn", "'LCS'");
        dms.insertTable(database, "Skole", "navn", "'BI'");

        dms.insertTable(database,"Kull", "kullkode, skole", "'2019H', 'UiB'");
        dms.insertTable(database,"Kull", "kullkode, skole", "'2019V', 'LCK'");
        dms.insertTable(database,"Kull", "kullkode, skole", "'2018H', 'MIT'");
        dms.insertTable(database,"Kull", "kullkode, skole", "'2018V', 'BI'");
        dms.insertTable(database,"Kull", "kullkode, skole", "'2017H', 'LCK'");

        dms.insertTable(database,"Student","nr, navn, kull", "'0', 'Anne Annevik', '2019H'");
        dms.insertTable(database,"Student","nr, navn, kull", "'1', 'Chad Stealyourgirl', '2019V'");
        dms.insertTable(database,"Student","nr, navn, kull", "'2', 'David The Smoker', '2018H'");
        dms.insertTable(database,"Student","nr, navn, kull", "'3', 'Eivind Hackerson', '2018V'");
        dms.insertTable(database,"Student","nr, navn, kull", "'4', 'Oscar Boxter', '2017H'");

        dms.insertTable(database,"Karakter","kurskode, karakter, year, student", "'1001', 'E', '2019', '0'");
        dms.insertTable(database,"Karakter","kurskode, karakter, year, student", "'2002', 'D', '2019', '1'");
        dms.insertTable(database,"Karakter","kurskode, karakter, year, student", "'3003', 'C', '2018' ,'2'");
        dms.insertTable(database,"Karakter","kurskode, karakter, year, student", "'4004', 'B', '2018' ,'3'");
        dms.insertTable(database,"Karakter","kurskode, karakter, year, student", "'5005', 'A', '2018', '4'");

        dms.insertTable(database,"Kurs","kurskode, navn, skole","'INFO001', 'Introduction to coding', 'UiB'" );
        dms.insertTable(database,"Kurs","kurskode, navn, skole","'LCK002', 'Pro Player', 'LCK'" );
        dms.insertTable(database,"Kurs","kurskode, navn, skole","'JMS003', 'Advanced mathmathics', 'MIT'" );
        dms.insertTable(database,"Kurs","kurskode, navn, skole","'PGT004', 'Success with stocks', 'BI'" );
        dms.insertTable(database,"Kurs","kurskode, navn, skole","'BTS005', 'Try to be as good as lck', 'LCS'" );
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        runApplication(scanner);
        createDatabase();
        matTabellen(database);
        launch(args);
    }

    private static String resource;

    //Fikk lov av eivind å bruke hans scanner for å displaye hver fx versjon. github: https://github.com/EwyBoy/SQL-Test/blob/master/src/main/Main.java
    private static void runApplication(Scanner scanner) {
        System.out.println("Type '1' to launch the test data table");
        System.out.println("Type '2' to launch Task TASK E window");
        System.out.println("Type '3' to launch Task TASK G window");
        System.out.println("Type '4' to launch Task TASK F window");
        System.out.println("Info: You may have to delete the database for it work properly after each launch..");

        String option = scanner.nextLine().toLowerCase();

        if (option.contentEquals("1")) {
            resource = "sample.fxml";
        } else if (option.contentEquals("2")) {
            resource = "studentGrades.fxml";
        } else if (option.contentEquals("3")) {
            resource = "kull.fxml";
        } else if (option.contentEquals("4")) {
            resource = "studentRegistration.fxml";
        }
        System.out.println(resource);
    }
}

