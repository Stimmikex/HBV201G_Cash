/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.utlit;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Styrmir Óli
 */
public class HradbankiMainController implements Initializable {

    @FXML
    private TextField PinId;
    @FXML
    private HradBankiKeybordController hradBankiKeybordController;
    private int[] pinArray;
    private String currentPin;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //hradBankiKeybordController = new HradBankiKeybordController();
        hradBankiKeybordController.getKeybord(this);
    }    

    @FXML
    private void PinHandler(KeyEvent event) {
    }
    /*
    public void setPinId() {
        pinArray = hradBankiKeybordController.getNumberArray();
        String DisplayPin = new String();
        for(int i = 0; i < pinArray.length; i++) {
            DisplayPin += pinArray[i];
        }
        PinId.setText(DisplayPin);
    }
    */
    public void displayPin() {
        currentPin += hradBankiKeybordController.DisplayNumber();
        System.out.println("Current:"+currentPin);
        PinId.setText(currentPin);
    }
}
