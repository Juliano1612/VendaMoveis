/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendasmoveis;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author ander
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button buttonLogar;
    private Button buttonCancelar;
    private TextField textFieldSenha;
    private TextField textFieldLogin;
    
    @FXML
    private void logarAction(ActionEvent event) {
        System.out.println("O botão Logar foi acionado");
    }
    @FXML
    void cancelarAction(ActionEvent event){
        System.out.println("Cancelar foi executado");
    }
    @FXML
    void apagarLogin(ActionEvent event){
        textFieldLogin.setText("");
    }
    @FXML
    void apagarSenha(ActionEvent event){
        textFieldSenha.setText("");
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
