package fx.controller;

import Main.Main;
import db.DatabaseManagingSystem;
import fx.models.StudentOne;
import fx.models.StudentTwo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Brukte mye kode fra Eivind, githuben hans ligger her: https://github.com/EwyBoy/SQL-Test/blob/master/src/fx/controllers/StudentController.java
public class StudentController implements Initializable {

    @FXML
    private TextField tab_name;

    @FXML
    private TableView<StudentOne> stable0;

    @FXML
    private TableColumn<StudentOne, String> tab_kursnavn;

    @FXML
    private TableColumn<StudentOne, String> tab_kurskode;

    @FXML
    private TableColumn<StudentOne, String> tab_karakter;

    @FXML
    private TableColumn<StudentOne, String> tab_year;

    @FXML
    private TableView<StudentTwo> stable1;

    @FXML
    private TableColumn<StudentTwo, String> tab_skole;

    @FXML
    private TableColumn<StudentTwo, String> tab_kull;

    private ObservableList<StudentOne> tableOneList = FXCollections.observableArrayList();
    private ObservableList<StudentTwo> tableTwoList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tab_name.setText("Arne Treholt");

        try(
                Connection connection = DatabaseManagingSystem.connect(Main.database);
                Statement statement = connection.createStatement()
        ) {

            ResultSet kursnavn = statement.executeQuery("SELECT kurskode FROM Karakter WHERE student=1;");
            ResultSet kurskode = statement.executeQuery("SELECT Kurs.kurskode FROM Kurs, Skole, Kull, Student WHERE Kurs.skole=Skole.navn AND Kull.skole=Skole.navn AND Kull.kullkode = kull AND Student.nr=1;");
            ResultSet karakter = statement.executeQuery("SELECT karakter FROM Karakter WHERE student=1;");
            ResultSet year = statement.executeQuery("SELECT year FROM Karakter WHERE student=1;");

            tableOneList.add(
                    new StudentOne(
                            "Avansert Programmering",
                            "INFO-233",
                            "C",
                            year.getString("year"))
            );

            ResultSet skole = statement.executeQuery("SELECT skole FROM Kull WHERE skole='UiB';");
            ResultSet kull = statement.executeQuery("SELECT skole FROM Student, Kull WHERE kode=kullkode AND nr=1;");

            tableTwoList.add(
                    new StudentTwo(
                            skole.getString("skole"),
                            "2019V"/*kull.getString("skole")*/
                    )
            );

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        tab_kursnavn.setCellValueFactory(new PropertyValueFactory<>("kursnavn"));
        tab_kurskode.setCellValueFactory(new PropertyValueFactory<>("kurs"));
        tab_karakter.setCellValueFactory(new PropertyValueFactory<>("karakter"));
        tab_year.setCellValueFactory(new PropertyValueFactory<>("year"));

        tab_skole.setCellValueFactory(new PropertyValueFactory<>("skole"));
        tab_kull.setCellValueFactory(new PropertyValueFactory<>("kull"));

        stable0.setItems(tableOneList);
        stable1.setItems(tableTwoList);

    }
}