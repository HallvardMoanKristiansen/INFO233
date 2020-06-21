package fx.controller;

import Main.Main;
import db.Database;
import db.DatabaseManagingSystem;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

//src Eivind Norling
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    private Button f_register;

    @FXML
    private TextField f_id;

    @FXML
    private TextField f_name;

    @FXML
    private TextField f_kull;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        f_register.setOnAction(e -> {
            register(f_id.getText(), f_name.getText(), f_kull.getText());
        });
    }

    private void register(String id, String name, String kull) {

        DatabaseManagingSystem databaseManagingSystem = new DatabaseManagingSystem();
        Database database = Main.database;

        try(
                Connection connection = DatabaseManagingSystem.connect(Main.database);
                Statement statement = connection.createStatement()
        ) {
            String entry = "'" + id + "', '" + name + "', '" + kull + "'";
            databaseManagingSystem.insertTable(database, "Student", "nr, navn, kull", entry);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
