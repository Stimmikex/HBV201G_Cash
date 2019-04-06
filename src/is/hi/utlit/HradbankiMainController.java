/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.utlit;
import is.hi.utlit.vinnsla.testdb;

import java.io.File;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
    private Pane mainBalance;
    
    
    @FXML
    private Button RControls_quit;
    @FXML
    private Button BControls_1;
    @FXML
    private Button BControls_2;
    @FXML
    private Button BControls_3;
    @FXML
    private Button BControls_4;
    @FXML
    private Button BControls_5;
    @FXML
    private Button BControls_6;
    @FXML
    private Button BControls_7;
    
    private String PinDisplay;
    private String currentCard;
    private int currentBalance;
    @FXML
    private ListView<String> transView;
    @FXML
    private TextField balanceDisplay;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currentPaneIndex = 0;
        resetControls();
    }
    public void pinChecker() throws SQLException {
        ResultSet rset = testdb.rundb("SELECT * FROM Cards WHERE pin = "+PinDisplay);
        int rowCount = 0;
        while(rset.next()) {   // Move the cursor to the next row, return false if no more row
           String id = rset.getString("id");
           currentCard = id;
           System.out.println(currentCard);
           String number = rset.getString("cardnumber");
           int pin = rset.getInt("pin");
           int bal = rset.getInt("balance");
           currentBalance = bal;
           System.out.println("Cardnumber: "+number);
           System.out.println("Pin: "+pin);
           System.out.println("Balance: "+bal);
           System.out.println();
           ++rowCount;
        }
    }
    public void displayTrans() throws SQLException {
        ResultSet rset = testdb.rundb("SELECT * FROM trans WHERE cards_id = "+currentCard);
        int rowCount = 0;
        ObservableList<String> items =FXCollections.observableArrayList();
        while(rset.next()) {   // Move the cursor to the next row, return false if no more row
           String info = rset.getString("info");
           System.out.println("Info: "+info);
           items.add(info);
           ++rowCount;
        }
        transView.setItems(items);
    }
    public void setBalanceValue(int value) throws SQLException {
        testdb.updateQuery("Update Cards SET balance ='"+(currentBalance-value)+"' WHERE pin = "+PinDisplay);
        testdb.updateQuery("INSERT INTO trans (info, cards_id) VALUES ('-"+value+"','"+currentCard+"')");
        currentBalance = currentBalance - value;
    }

    
    @FXML
    private void PinHandler(KeyEvent event) {
        
    }
    public void displayPin(){
        String pin = new String();
        for(int i = 0; i < currentIndex;i++) {
            pin += numberArray[i];
        }
        PinId.setText(pin);
    }

    @FXML
    private void enterHandler(ActionEvent event) throws SQLException {
        if(currentIndex == 4) {
            numberArray = new int[4];
            PinDisplay = PinId.getText();
            PinId.setText("");
            pinChecker();
            if(currentPaneIndex == 0) {
                mainPin.setVisible(false);
                lastPane = mainPin;
                mainMenu.setVisible(true);
                currentPane = mainMenu;
                currentPaneIndex = 1;
                getMenu();
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
    private void quitEnter (ActionEvent event) throws SQLException {
        
    }

    @FXML
    private void numberHandler(ActionEvent event) {
        ButtonSound();
        if (currentIndex < 4) {
            Button button = (Button)event.getSource();
            int id = Integer.parseInt(button.getText());
            numberArray[currentIndex] = id;
            currentIndex += 1;
            //System.out.println(currentIndex);
            displayPin();
            //System.out.println();
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
        currentIndex = 0;
        currentPaneIndex = 0;
        resetControls();
    }

    @FXML
    private void ControlsHandler(ActionEvent event) throws SQLException {
        Button button = (Button)event.getSource();
        String numberOfButton = button.getId().toString();
        numberOfButton = numberOfButton.substring(numberOfButton.length()-1,numberOfButton.length());
        int NOB = Integer.parseInt(numberOfButton);
        System.out.println(numberOfButton);
        resetControls();
         switch (currentPaneIndex) {
            case 1:
                currentPane = mainMenu;
                getMenu();
                switch (NOB) {
                    case 4:
                        System.out.println("Pane2");
                        currentPaneIndex = 2;
                        break;
                    case 6:
                        System.out.println("Pane4");
                        currentPaneIndex = 4;
                        break;
                    case 7:
                        System.out.println("Pane3");
                        currentPaneIndex = 3;
                        break;
                    default:
                        break;
                }
            break;
            case 2:
                currentPane = mainTakeout;
                getWith();
                int value = 0;
                switch (NOB) {                
                    case 1:
                        value = 500;
                        break;
                    case 2:
                        value = 1000;
                        break;
                    case 3:
                        value = 3000;
                        break;
                    case 4:
                        value = 5000;
                        break;
                    case 5:
                        value = 10000;
                        break;
                    case 6:
                        value = 15000;
                        break;
                    case 7:
                        break;
                    default:
                        break;
                }
                System.out.println("Bal: "+currentBalance);
                System.out.println("Value: "+value);
                if ((currentBalance-value) > 0) {
                    setBalanceValue(value);
                }
            break;
            case 3:
                currentPane = mainBalance;
                getBalance();
                switch (NOB) {
                    case 4:
                        getWith();
                        currentPane.setVisible(false);
                        break;
                    default:
                        break;
                }
            break;
            case 4:
                currentPane = mainList;
                getList();
                displayTrans();
                switch (NOB) {
                    case 4:
                        getWith();
                        currentPane.setVisible(false);
                        break;
                    default:
                        break;
                }
            break;

        default:
            break;
      }
    }
    public void getMenu() {
        BControls_1.setText("");
        //BControls_1.setDisable(true);
        BControls_2.setText("");
        //BControls_2.setDisable(true);
        BControls_3.setText("");
        //BControls_3.setDisable(true);
        BControls_4.setText("Taka út");

        BControls_5.setText("");
        //BControls_5.setDisable(true);
        BControls_6.setText("Færslur");
        BControls_7.setText("Staða");
        
        currentPane.setVisible(false);
        mainMenu.setVisible(true);
    }
    public void getWith() {
        BControls_1.setText("500");
        BControls_2.setText("1000");
        BControls_3.setText("3000");
        BControls_4.setText("5000");

        BControls_5.setText("10000");
        BControls_6.setText("15000");
        BControls_7.setText("Velja");
        
        currentPane.setVisible(false);
        mainTakeout.setVisible(true);
    }
    public void getBalance() throws SQLException {
        balanceDisplay.setText(Integer.toString(currentBalance));
        BControls_4.setText("Taka út");
        currentPane.setVisible(false);
        mainBalance.setVisible(true);
    }
    public void getList() {
        BControls_4.setText("Taka út");
        currentPane.setVisible(false);
        mainList.setVisible(true);
    }
    public void resetControls() {
        BControls_1.setText("");
        BControls_2.setText("");
        BControls_3.setText("");
        BControls_4.setText("");

        BControls_5.setText("");
        BControls_6.setText("");
        BControls_7.setText("");
        
        mainMenu.setVisible(false);
        mainTakeout.setVisible(false);
        mainBalance.setVisible(false);
        mainList.setVisible(false);
    }
}
