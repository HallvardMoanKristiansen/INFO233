package db;

import java.io.File;

public class Database {

    private File database;
    private String sql;
    private String url;
    private String databaseName;

    //https://github.com/EwyBoy/SQL-Test/blob/master/src/database/Database.java
    //Eivind hadde denne fantastiske koden hvor man kan bestemme navnet på databasen, og oprette flere om det trengs.
    public Database(String name) {
        this.database = new File(name + ".db");
        this.sql = name + ".sql";
        this.url = "jdbc:sqlite:" + database.getPath();
        this.databaseName = name;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public File getDatabase() {
        return database;
    }

    public String getSql() {
        return sql;
    }

    public String getUrl() {
        return url;
    }

}