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
    private int[] pinArray;
    private String currentPin;
    @FXML
    private Button KeyBord_1;
    @FXML
    private Button KeyBord_4;
    @FXML
    private Button KeyBord_7;
    @FXML
    private Button KeyBord_10;
    @FXML
    private Button KeyBord_2;
    @FXML
    private Button KeyBord_5;
    @FXML
    private Button KeyBord_8;
    @FXML
    private Button KeyBord_0;
    @FXML
    private Button KeyBord_3;
    @FXML
    private Button KeyBord_6;
    @FXML
    private Button KeyBord_9;
    @FXML
    private Button KeyBord_11;
    @FXML
    private Button KeyBord_Enter;
    @FXML
    private Button KeyBord_Cancel;
    @FXML
    private Button KeyBord_Quit;
    
    private int[] numberArray = new int[4];
    private int pinSum;
    private int selectedButton;
    private int currentIndex;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
        System.out.println("Current:"+currentPin);
        PinId.setText(currentPin);
    }

    @FXML
    private void enterHandler(ActionEvent event) {
        if(currentIndex <= 4) {
            
        }
    }

    @FXML
    private void cancelHandler(ActionEvent event) {
        if (currentIndex >= 1) {
            numberArray[currentIndex] = 0;
            currentIndex -= 1;
        }
    }

    @FXML
    private void quitEnter(ActionEvent event) {
    }

    @FXML
    private void numberHandler(ActionEvent event) {
        if (currentIndex < 4) {
            Button button = (Button)event.getSource();
            int id = Integer.parseInt(button.getText());
            pinSum += (id*1000)/Math.pow(10, currentIndex);
            System.out.println(pinSum);
            numberArray[currentIndex] = id;
            currentIndex += 1;
            for(int i = 0; i < currentIndex; i++) {
                System.out.print(numberArray[i]+",");
            }
            System.out.println();
        } else {
            System.out.println("Error");
        }
    }
}
