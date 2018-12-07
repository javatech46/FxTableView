/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmltableview;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Chetan
 */
public class AlertBoxController implements Initializable {

    /**
     * Initializes the controller class.
     *
     *
     */
    @FXML
    private TextFlow text;
    @FXML
    private Text textData;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void Ok(ActionEvent ae) {

        Stage stage = (Stage) text.getScene().getWindow();
        stage.close();

    }
    
     public void setData(String id, String name, String salary) {
        
        textData.setText("Id : " + id + "  Name : " + name + "  Salary : " + salary);

    }
    

   
}
