package fxmltableview;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Chetan
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TableView<EmployeeBean> employee;
    @FXML
    private TableColumn<EmployeeBean, Integer> salary, id;
    @FXML
    private TableColumn<EmployeeBean, String> name;

    private ObservableList<EmployeeBean> masterData4;
    private ObservableList<String> masterData3;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        masterData3 = FXCollections.observableArrayList();
        masterData4 = FXCollections.observableArrayList();

        masterData3.add("Ganesh");
        masterData3.add("Abhijit");
        masterData3.add("Vinod");

        // TODO
        employee.getItems().add(new EmployeeBean(1, 2000, "Chetan"));
        employee.getItems().add(new EmployeeBean(2, 2000, "Prashant"));
        employee.getItems().add(new EmployeeBean(3, 4000, "Pramod"));

        salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        employee.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
          
                FXMLLoader Loader = new FXMLLoader();
                Loader.setLocation(getClass().getResource("AlertBox.fxml"));
                
                try {
                    Loader.load();
                } catch (IOException ex) {
                 ex.printStackTrace();
                    
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                AlertBoxController alertBoxController = Loader.getController();
                alertBoxController.setData(""+employee.getSelectionModel().getSelectedItem().getId(), employee.getSelectionModel().getSelectedItem().getName(),""+employee.getSelectionModel().getSelectedItem().getSalary());
                Parent p = Loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.show();
                
                
                
            }
                    
        });

    }

}