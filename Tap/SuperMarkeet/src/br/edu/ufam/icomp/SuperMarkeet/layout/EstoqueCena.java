package br.edu.ufam.icomp.SuperMarkeet.layout;

import br.edu.ufam.icomp.SuperMarkeet.Produto;
import br.edu.ufam.icomp.SuperMarkeet.ProdutoDAO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class EstoqueCena {
    
    String codigoProduto;

    @FXML
    private Button addProduto;

    @FXML
    private Button removProd;

    @FXML
    private ListView<String> listaProdutos;

    @FXML
    private TextField quantidadeRemov;

    @FXML
    private Label gastos;

    @FXML
    private Button voltar;
   
    private ProdutoDAO produtoDAO;
    
    public void initialize() {
        Alert info = new Alert(Alert.AlertType.INFORMATION);
        info.setTitle("Como funciona?");
        info.setHeaderText(null);
        info.setContentText("Para adicionar produtos ao estoque simplesmente clique no botão adicionar e preencha todos os campos.");
        info.showAndWait();
        produtoDAO = new ProdutoDAO();
        atualizarListaProdutos();
        selectItem();
    }
    public void selectItem() {
        listaProdutos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue != null) {
                    String[] partes = newValue.split("\\|");
                    codigoProduto = partes[0].trim();
                }
            }
        });
    }
    
    private void atualizarListaProdutos() {
        listaProdutos.getItems().clear();

        try {

            List<Produto> produtos = produtoDAO.listarProdutos();

            for (Produto produto : produtos) {
                listaProdutos.getItems().add(produto.getCodigoDeBarras() + " | " + produto.getDescricao() + " | R$ " + produto.getPrecoCompra() +
                " | R$ " + produto.getPrecoVenda() + " | Quantidade: " + produto.getQuantidade() + " | " + produto.getUnidadeMedida());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        gastos.setText("Gastos: R$" + GerenciadorVendas.getCompraProduto());
    }

    @FXML
    void botaoVoltar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
            Parent root = loader.load();
            
            
            Stage stage = (Stage) voltar.getScene().getWindow();
            
         
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     @FXML
    void adicionarProduto(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("adicionarProduto.fxml"));
            Parent root = loader.load();
            Image icon = new Image(getClass().getResourceAsStream("SuperMartIcon.jpeg"));
            

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.getIcons().add(icon);
            stage.setScene(scene);
            stage.setTitle("Informe os dados corretamente");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
            atualizarListaProdutos();
    }

    @FXML
    void removerProduto(ActionEvent event) {
        Produto produto = produtoDAO.getProduto(codigoProduto);
        String quantidadeText = quantidadeRemov.getText();
        if(produto == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Produto não selecionado");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecione um produto.");
            alert.showAndWait();
        }
        else{
            int numero;
            if(quantidadeText.isEmpty()){
                numero = 1;
            }
            else{
                numero = Integer.parseInt(quantidadeText);
            }
            if(numero >produto.getQuantidade()){
                numero = produto.getQuantidade();
            }
            if (produto != null) {
                while(numero > 0){    
                    if (produto.getQuantidade() > 1) {
                        produto.decrementaQuantidade();
                        produtoDAO.atualizarProdutos(produto);
                    } else {
                        produtoDAO.removeProduto(codigoProduto);
                    }
                    GerenciadorVendas.setCompraProdutos(-produto.getPrecoCompra());
                    numero--;
                }
            }
        }
        atualizarListaProdutos();
    }

    
}
