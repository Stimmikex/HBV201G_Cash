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
import java.lang.Math;

/**
 * FXML Controller class
 *
 * @author Styrmir Óli
 */
public class HradBankiKeybordController implements Initializable {

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
    
    private HradbankiMainController hradbankiMainController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //hradbankiMainController = new HradbankiMainController();
    }    

    @FXML
    private void enterHandler(ActionEvent event) {
        if(currentIndex <= 4) {
            getNumberArray();
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
            hradbankiMainController.displayPin();
            System.out.println();
        } else {
            System.out.println("Error");
        }
    }
    public int[] getNumberArray() {
        return numberArray;
    }
    public String DisplayNumber() {
        System.out.println(selectedButton);
        return Integer.toString(pinSum);
    }
    public void getKeybord(HradbankiMainController hradbankiMainController) {
        this.hradbankiMainController = hradbankiMainController;
    }
}
