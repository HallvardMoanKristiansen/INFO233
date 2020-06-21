package fx.controller;

import Main.Main;
import db.DatabaseManagingSystem;
import fx.models.ModelTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

//tablecontroller implementerer initializable, og under linker jeg til hver av colonnene, som jeg har gitt navn col_".....".
public class TableController implements Initializable {

    @FXML
    private TableView<ModelTable> table;

    @FXML
    private TableColumn<ModelTable, String> col_kurskode;

    @FXML
    private TableColumn<ModelTable, String> col_karakter;

    @FXML
    private TableColumn<ModelTable, String> col_year;

    @FXML
    private TableColumn<ModelTable, String> col_student;

    private ObservableList<ModelTable> oblist = FXCollections.observableArrayList();

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            Connection connection = DatabaseManagingSystem.connect(Main.database);
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM main.Karakter");
            while (rs.next()) {
                oblist.add(
                        new ModelTable(
                                rs.getString("kurskode"),
                                rs.getString("karakter"),
                                rs.getString("year"),
                                rs.getString("student")
                        )
                );
            }
            //catcher statementen slik at programmet ikke krasjer
        } catch (SQLException e) {
            System.out.println(TableController.class.getName());
        }

        //Setter verdier til hver colonne.
        col_kurskode.setCellValueFactory(new PropertyValueFactory<>("kurskode"));
        col_karakter.setCellValueFactory(new PropertyValueFactory<>("karakter"));
        col_year.setCellValueFactory(new PropertyValueFactory<>("year"));
        col_student.setCellValueFactory(new PropertyValueFactory<>("student"));

        table.setItems(oblist);

    }
}
