package br.edu.ufam.icomp.SuperMarkeet.layout;

import br.edu.ufam.icomp.SuperMarkeet.Produto;
import br.edu.ufam.icomp.SuperMarkeet.ProdutoDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ProdutoController {

    @FXML
    private TextField codigoDeBarrasTextField;

    @FXML
    private TextField descricaoTextField;

    @FXML
    private TextField precoDeCompraTextField;

    @FXML
    private TextField precoDeVendaTextField;

    @FXML
    private TextField quantidadeCompradaTextField;

        @FXML
    private ChoiceBox<String> unidadeMedida;
    private String[] medidas = {"Kg", "L", "g", "Ml"};

    @FXML
    private Button confirmarButton;

    public void initialize() {
        unidadeMedida.getItems().addAll(medidas);
    }

    @FXML
    void confirmar() {
        String codigoDeBarras = codigoDeBarrasTextField.getText();
        String descricao = descricaoTextField.getText();
        String precoDeCompraText = precoDeCompraTextField.getText();
        String precoDeVendaText = precoDeVendaTextField.getText();
        String quantidadeCompradaText = quantidadeCompradaTextField.getText();
        String medida = unidadeMedida.getValue();

        // Verifica se algum dos campos está vazio
        if (codigoDeBarras.isEmpty() || descricao.isEmpty() || precoDeCompraText.isEmpty() ||
            precoDeVendaText.isEmpty() || quantidadeCompradaText.isEmpty() || medida == null) {
            // Exibe um alerta de aviso
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Campos Vazios");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, preencha todos os campos.");
            alert.showAndWait();
        } else {
            double precoDeCompra = Double.parseDouble(precoDeCompraText);
            double precoDeVenda = Double.parseDouble(precoDeVendaText);
            int quantidadeComprada = Integer.parseInt(quantidadeCompradaText);

            ProdutoDAO produtoDAO = new ProdutoDAO();
            Produto produto = new Produto(codigoDeBarras, descricao, precoDeCompra, precoDeVenda, quantidadeComprada, medida);
            produtoDAO.adicionarProduto(produto);
            
            // Exibe uma mensagem de confirmação
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Produto Adicionado");
            alert.setHeaderText(null);
            alert.setContentText("O produto foi adicionado com sucesso!");
            alert.showAndWait();
            
            GerenciadorVendas.setLucroTotal(precoDeCompra * quantidadeComprada);
            GerenciadorVendas.setCompraProdutos(precoDeCompra * quantidadeComprada);
            
            Stage stage = (Stage) confirmarButton.getScene().getWindow();
            stage.close();
        }
    }

}
