package br.edu.ufam.icomp.SuperMarkeet.layout;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SceneController {

    @FXML
    private Button botaoControle;

    @FXML
    private Label lucroTotal;

    @FXML
    private Button botaoRelatorio;

    @FXML
    private Button botaovenda;

    @FXML
    void controle(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Estoque.fxml"));
            Parent root = loader.load();
        
            Stage stage = (Stage) botaoControle.getScene().getWindow();
            
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void relatorio(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("relatorio.fxml"));
            Parent root = loader.load();
        
            Stage stage = (Stage) botaoControle.getScene().getWindow();
            
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void venda(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdiocionarVendas.fxml"));
            Parent root = loader.load();
        
            Stage stage = (Stage) botaoControle.getScene().getWindow();
            
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
