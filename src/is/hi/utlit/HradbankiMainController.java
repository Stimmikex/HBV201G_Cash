/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.utlit;
import is.hi.utlit.vinnsla.testdb;

import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Styrmir Óli
 */
public class HradbankiMainController implements Initializable {

    @FXML
    private TextField PinId;
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
    private int currentIndex;
    private int currentPaneIndex;
    private int backIndex;
    private Media sound;
    private MediaPlayer mediaPlayer;
    @FXML
    private Button musicButton;
    
    private Pane currentPane;
    private Pane lastPane;
    
    @FXML
    private Pane mainPin;
    @FXML
    private Pane mainTakeout;
    @FXML
    private Pane mainList;
    @FXML
    private Pane mainMenu;
    
    
    @FXML
    private Button LControls_1;
    @FXML
    private Button LControls_2;
    @FXML
    private Button LControls_3;
    @FXML
    private Button LControls_4;
    @FXML
    private Button RControls_1;
    @FXML
    private Button RControls_2;
    @FXML
    private Button RControls_3;
    @FXML
    private Button RControls_quit;
    @FXML
    private Pane mainBalance;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currentPaneIndex = 0;
    }
    public void dbtesting() throws SQLException {
        PinId.setText(testdb.rundb());
    }

    @FXML
    private void PinHandler(KeyEvent event) {
        
    }
    public void displayPin(){
        System.out.println("Testing");
        String pin = new String();
        for(int i = 0; i < currentIndex;i++) {
            pin += numberArray[i];
        }
        PinId.setText(pin);
    }

    @FXML
    private void enterHandler(ActionEvent event) {
        if(currentIndex == 4) {
            numberArray = new int[4];
            PinId.setText("");
            if(currentPaneIndex == 0) {
                mainPin.setVisible(false);
                lastPane = mainPin;
                mainMenu.setVisible(true);
                currentPane = mainMenu;
            }
        }
    }

    @FXML
    private void cancelHandler(ActionEvent event) {
        if (currentIndex > 0) {
            currentIndex -= 1;
            numberArray[currentIndex] = 0;
            displayPin();
        }
    }

    @FXML
    private void quitEnter (ActionEvent event) {
        //dbtesting();
    }

    @FXML
    private void numberHandler(ActionEvent event) {
        ButtonSound();
        if (currentIndex < 4) {
            Button button = (Button)event.getSource();
            int id = Integer.parseInt(button.getText());
            numberArray[currentIndex] = id;
            currentIndex += 1;
            System.out.println(currentIndex);
            displayPin();
            System.out.println();
        } else {
            System.out.println("Error");
        }
    }
    private void ButtonSound() {
        String musicFile = "src/is/hi/soundfiles/TheTruth2.mp3";     // For example
        sound = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.stop();
        mediaPlayer.play();
    }

    @FXML
    private void musicHandler(ActionEvent event) {
        String musicFile = "src/is/hi/soundfiles/Money.mp3";     // For example
        sound = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.stop();
        mediaPlayer.play();
    }

    @FXML
    private void quitControlsHandler(ActionEvent event) {
        currentPane.setVisible(false);
        lastPane.setVisible(true);
        currentIndex-=backIndex;
    }

    @FXML
    private void RControlsHandler(ActionEvent event) {
        switch (currentPaneIndex) {
            case 1:

            break;
            case 2:
                RControls_1.setText("");
                RControls_2.setText("Færslur");
                RControls_3.setText("Staða");
                
                LControls_1.setText("");
                LControls_2.setText("");
                LControls_3.setText("");
                LControls_4.setText("Taka út");
            break;
            case 3:

            break;
            case 4:

            break;
            case 5:

            break;

        default:
            break;
      }
    }

    @FXML
    private void LControlsHandler(ActionEvent event) {
    }

    @FXML
    private void takeHandler(ActionEvent event) {
    }
}
