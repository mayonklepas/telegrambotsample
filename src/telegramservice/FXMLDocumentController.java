/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegramservice;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.TelegramBotsApi;

/**
 *
 * @author Minami
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML 
    private Button bon;
    @FXML
    private TextArea tlog;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        start();
    }


    private void start(){
        bon.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    TelegramBotsApi tba=new TelegramBotsApi();
                    tba.registerBot(new Telegramhelper());
                    tlog.appendText("telegram Bot Server ON");
                    bon.disableProperty().set(true);
                } catch (TelegramApiException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
}
