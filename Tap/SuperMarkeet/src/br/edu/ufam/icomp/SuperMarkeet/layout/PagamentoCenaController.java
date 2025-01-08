package br.edu.ufam.icomp.SuperMarkeet.layout;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PagamentoCenaController {

    @FXML
    private Button okButton;

    @FXML
    private TextField totalPagoTextField;

    @FXML
    private ChoiceBox<String> tipoPagamento;
    private String[] pagamento = {"dinheiro", "cartao de credito", "cartao de debito", "pix"};

    public void initialize(){
        tipoPagamento.getItems().addAll(pagamento);
    }

    public String getTotalPago() {
        return totalPagoTextField.getText();
    }

    public String getTipoPagamento() {
        return tipoPagamento.getValue();
    }

    @FXML
    void okButtonPressed(ActionEvent event) {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }
}
